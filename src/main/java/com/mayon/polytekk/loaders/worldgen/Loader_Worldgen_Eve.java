package com.mayon.polytekk.loaders.worldgen;

import com.mayon.polytekk.loaders.ores.PT_Loader_Materials;
import gregapi.config.ConfigCategories;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregapi.worldgen.WorldgenOresLarge;
import gregtech.worldgen.WorldgenRocks;

import static com.mayon.polytekk.data.PT_BiomeDim.GEN_EVE;
import static gregapi.data.CS.*;
import static gregapi.data.CS.ORE_DEEPDARK;

public class Loader_Worldgen_Eve implements Runnable {

    public void run() {

        boolean
            tInfiniteOil = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteOilSources", F),
            tInfiniteGas = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteGasSources", F);

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_EVE);

        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  7000, MT.Adamantine                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.plutonium"   , T, T,  7000, MT.Pu                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.schrabidium"   , T, T,  7000, PT_Loader_Materials.Schrabidium, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.solinium"   , T, T,  14000, PT_Loader_Materials.Solinium, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.tiberium"   , T, T,  7000, PT_Loader_Materials.Tiberium, GEN_EVE);

        new WorldgenOresLarge("ore.large.adamantine"  , T, T, 1, 50,   7, 2, 16, MT.OREMATS.BrownLimonite        , MT.OREMATS.YellowLimonite      , MT.Fe2O3                       , MT.Adamantine         , GEN_EVE);
        new WorldgenOresLarge("ore.large.tiberium"  , T, T, 1, 255,   7, 3, 22, PT_Loader_Materials.Tiberium, MT.BlueSapphire      , MT.Ruby                       , PT_Loader_Materials.Tiberium         , GEN_EVE);

    }

}
