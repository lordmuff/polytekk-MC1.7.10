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
    private static final List<Runnable> LIST = new ArrayListNoNulls<>();
    private static boolean LOCK = F;

    public static void generate(World aWorld, int aX, int aZ) {

            if (PT_BiomeDim.dimMoho           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MOHO,      ORE_MOHO                     , DIM_MOHO            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimEve            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_EVE,       ORE_EVE                      , DIM_EVE             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimMun            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MUN,       ORE_MUN                      , DIM_MUN             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimMinmus         (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_MINMUS,    ORE_MINMUS                   , DIM_MINMUS          , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimDuna           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DUNA,      ORE_DUNA                     , DIM_DUNA            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimDres           (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_DRES,      ORE_DRES                     , DIM_DRES            , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimIke            (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_IKE,       ORE_IKE                      , DIM_IKE             , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimLaythe         (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_LAYTHE,    ORE_LAYTHE                   , DIM_LAYTHE          , aWorld, aX, aZ)); return;}
            if (PT_BiomeDim.dimTekto          (aWorld)) {generate(new GT6WorldGenerator.WorldGenContainer(GEN_TEKTO,     ORE_TEKTO                    , DIM_TEKTO           , aWorld, aX, aZ)); return;}

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
