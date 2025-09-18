package com.mayon.polytekk.loaders.worldgen;

import com.hbm.config.SpaceConfig;
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
    private static final List<Runnable> LIST = new ArrayListNoNulls<>();
    private static boolean LOCK = F;

    public static void generate(World aWorld, int aX, int aZ) {

            if (aWorld.provider.dimensionId == SpaceConfig.mohoDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MOHO,      ORE_MOHO                     , SpaceConfig.mohoDimension            , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.eveDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_EVE,       ORE_EVE                      , SpaceConfig.eveDimension             , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.moonDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MUN,       ORE_MUN                      , SpaceConfig.moonDimension             , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.minmusDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MINMUS,    ORE_MINMUS                   , SpaceConfig.minmusDimension          , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.dunaDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DUNA,      ORE_DUNA                     , SpaceConfig.dunaDimension            , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.dresDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DRES,      ORE_DRES                     , SpaceConfig.dresDimension            , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.ikeDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_IKE,       ORE_IKE                      , SpaceConfig.ikeDimension             , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.laytheDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_LAYTHE,    ORE_LAYTHE                   , SpaceConfig.laytheDimension          , aWorld, aX, aZ)); return;}
            if (aWorld.provider.dimensionId == SpaceConfig.tektoDimension) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_TEKTO,     ORE_TEKTO                    , SpaceConfig.tektoDimension           , aWorld, aX, aZ)); return;}

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
