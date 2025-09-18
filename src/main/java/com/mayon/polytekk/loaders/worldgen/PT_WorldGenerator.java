package com.mayon.polytekk.loaders.worldgen;

import gregapi.code.ArrayListNoNulls;
import gregapi.code.BiomeNameSet;
import gregapi.util.WD;
import gregapi.worldgen.GT6WorldGenerator;
import gregapi.worldgen.WorldgenObject;
import gregapi.worldgen.WorldgenOresLarge;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import com.mayon.polytekk.data.PT_BiomeDim;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.mayon.polytekk.data.PT_BiomeDim.*;
import static gregapi.data.CS.*;

public class PT_WorldGenerator {

    public static class PT_WorldGenContainer implements Runnable {
        public final int mMinX, mMinZ, mMaxX, mMaxZ, mDimType;
        public final World mWorld;
        public final Random mRandom;
        public final List<WorldgenObject> mGenNormal;
        public final List<WorldgenObject> mGenLargeOres;

        public PT_WorldGenContainer(List<WorldgenObject> aGenNormal, List<WorldgenObject> aGenLargeOres, int aDimType, World aWorld, int aX, int aZ) {
            mMinX = aX; mMinZ = aZ; mMaxX = aX + 15; mMaxZ = aZ + 15;
            mDimType = aDimType;
            mWorld = aWorld;
            mGenNormal = aGenNormal;
            mGenLargeOres = aGenLargeOres;
            mRandom = WD.random(aWorld, aX, aZ);
        }

        @Override @SuppressWarnings("unchecked")
        public void run() {
            if (!mGenNormal.isEmpty()) {
                Chunk tChunk = mWorld.getChunkFromBlockCoords(mMinX+7, mMinZ+7);
                if (tChunk == null) return;
                BiomeGenBase[][] tBiomes = new BiomeGenBase[16][16];
                BiomeNameSet tBiomeNames = new BiomeNameSet();
                for (int i = 0; i < 16; i++) for (int j = 0; j < 16; j++) {
                    tBiomes[i][j] = tChunk.getBiomeGenForWorldCoords(i, j, mWorld.provider.worldChunkMgr);
                    if (tBiomes[i][j] == null) {
                        tBiomes[i][j] = (mDimType == DIM_NETHER ? BiomeGenBase.hell : mDimType == DIM_END ? BiomeGenBase.sky : BiomeGenBase.plains);
                    } else {
                        tBiomeNames.add(tBiomes[i][j].biomeName);
                    }
                }

                GENERATING_SPECIAL = F;

                // Yes, it has to be looped twice in a row, this cannot be optimized into one Loop!
                for (WorldgenObject tWorldGen : mGenNormal) tWorldGen.reset(mWorld, tChunk, mDimType, mMinX, mMinZ, mMaxX, mMaxZ, mRandom, tBiomes, tBiomeNames);
                for (WorldgenObject tWorldGen : mGenNormal) if (tWorldGen.enabled(mWorld, mDimType)) {
                    try {
                        tWorldGen.generate(mWorld, tChunk, mDimType, mMinX, mMinZ, mMaxX, mMaxZ, mRandom, tBiomes, tBiomeNames);
                    } catch (Throwable e) {
                        e.printStackTrace(ERR);
                    }
                    if (tChunk.lastSaveTime == Long.MAX_VALUE) {
                        tChunk.hasEntities = tChunk.isModified = F;
                        throw new RuntimeException("A corrupted Chunk was found while generating at (X: " + mMinX + " Z: " + mMinZ + "), please try loading the World again to see if this specific Chunk consistently corrupts, and >>>ONLY<<< if it does so, please report this to Greg.");
                    }
                }

                if (mGenLargeOres != null && !mGenLargeOres.isEmpty()) {
                    int tMaxWeight = 0;
                    List<WorldgenOresLarge> tList = new ArrayListNoNulls<>();

                    for (WorldgenObject tWorldGen : mGenLargeOres) if (tWorldGen.enabled(mWorld, mDimType)) {tMaxWeight += ((WorldgenOresLarge)tWorldGen).mWeight; tList.add((WorldgenOresLarge)tWorldGen);}

                    if (tMaxWeight > 0 && !tList.isEmpty()) for (int tX=-32; tX<=32; tX+=16) for (int tZ=-32; tZ<=32; tZ+=16) {
                        int tChunkX = mMinX+tX, tChunkZ = mMinZ+tZ;
                        if (((tChunkX >> 4)+402653184) % 3 == 1 && ((tChunkZ >> 4)+402653184) % 3 == 1) {
                            Random aRandom = WD.random(mWorld, tChunkX, tChunkZ);
                            int tRandomWeight = aRandom.nextInt(tMaxWeight);
                            for (WorldgenOresLarge tWorldGen : tList) {
                                tRandomWeight -= tWorldGen.mWeight;
                                if (tRandomWeight <= 0) {try {tWorldGen.generate(mWorld, tChunk, mMinX, mMinZ, mMaxX, mMaxZ, tChunkX, tChunkZ, mRandom);} catch (Throwable e) {e.printStackTrace(ERR);} break;}
                            }
                        }
                    }
                }

                // Kill off every single Item Entity that may have dropped during Worldgen.
                for (EntityItem tEntity : (List<EntityItem>)mWorld.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(mMinX-32, 0, mMinZ-32, mMinX+48, 256, mMinZ+48))) tEntity.setDead();
                // Prevent Snow Layers from killing Treestumps. I really hope this works...
                Arrays.fill(tChunk.precipitationHeightMap, -999);
                // Chunk got modified, duh.
                tChunk.isModified = T;
            }
        }
    }

    private static final List<Runnable> LIST = new ArrayListNoNulls<>();
    private static boolean LOCK = F;
    public static boolean PFAA = F, TFC = F;

    public static void generate(World aWorld, int aX, int aZ) {

            if (PT_BiomeDim.dimMoho           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MOHO,      ORE_MOHO                     , DIM_MOHO            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimEve            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_EVE,       ORE_EVE                      , DIM_EVE             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimMun            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MUN,       ORE_MUN                      , DIM_MUN             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimMinmus         (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MINMUS,    ORE_MINMUS                   , DIM_MINMUS          , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimDuna           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DUNA,      ORE_DUNA                     , DIM_DUNA            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimDres           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DRES,      ORE_DRES                     , DIM_DRES            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimIke            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_IKE,       ORE_IKE                      , DIM_IKE             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimLaythe         (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_LAYTHE,    ORE_LAYTHE                   , DIM_LAYTHE          , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimTekto          (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_TEKTO,     ORE_TEKTO                    , DIM_TEKTO           , aWorld, aX, aZ));}

        }

        public static void generate(GT6WorldGenerator.WorldGenContainer aWorldgen) {
            LIST.add(aWorldgen);
            if (!LOCK) {
                LOCK = T;
                while (!LIST.isEmpty()) LIST.remove(LIST.size()-1).run();
                LOCK = F;
            }
        }

    }
