package com.mayon.polytekk.loaders.worldgen;

import com.mayon.polytekk.loaders.ores.PT_Loader_Materials;
import gregapi.config.ConfigCategories;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregapi.worldgen.WorldgenOresLarge;
import gregtech.worldgen.WorldgenRocks;

import static com.mayon.polytekk.data.PT_BiomeDim.*;
import static gregapi.data.CS.*;
import static gregapi.data.CS.GEN_DEEPDARK;

public class Loader_Worldgen_Dres implements Runnable {

    public void run() {

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_DRES);

        new WorldgenOresBedrock("ore.bedrock.tengam"   , T, T,  12000, PT_Loader_Materials.Tengam                                , GEN_DRES);
        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  8000, MT.Adamantine                                , GEN_DRES);
        new WorldgenOresBedrock("ore.bedrock.tiberium"   , T, T,  6000, PT_Loader_Materials.Tiberium, GEN_DRES);
        new WorldgenOresBedrock("ore.bedrock.tantalite"   , T, T,  1250, MT.OREMATS.Tantalite, GEN_DRES);
        new WorldgenOresBedrock("ore.bedrock.naquadah"     , T, T,  5750, MT.Nq                                        , GEN_DRES);
        new WorldgenOresBedrock("ore.bedrock.trinium"     , T, T,  5500, MT.Ke                                        , GEN_DRES);

        new WorldgenOresLarge("ore.large.tantalite"  , T, T, 1, 80,   33, 1, 6, MT.OREMATS.Coltan        , MT.OREMATS.Coltan      , MT.OREMATS.Columbite                       , MT.OREMATS.Tantalite         , ORE_DRES);
        new WorldgenOresLarge("ore.large.adamantine"  , T, T, 1, 45,   21, 6, 48, MT.OREMATS.BrownLimonite        , MT.OREMATS.YellowLimonite      , MT.Adamantine                       , MT.Adamantine         , ORE_DRES);
        new WorldgenOresLarge("ore.large.tengam"  , T, T, 1, 20,   13, 3, 28, MT.Nd        , MT.Nd      , PT_Loader_Materials.Tengam                       , MT.Sm         , ORE_DRES);
        new WorldgenOresLarge("ore.large.tiberium"  , T, T, 1, 45,   13, 13, 56, MT.Ruby        , MT.BlueSapphire      , MT.Alexandrite                       , PT_Loader_Materials.Tiberium         , ORE_DRES);

    }

}
