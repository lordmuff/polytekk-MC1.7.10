package com.mayon.polytekk.loaders.worldgen;

import com.mayon.polytekk.PolyTekk_Main;
import com.mayon.polytekk.loaders.ores.PT_Loader_Ores;
import gregapi.config.ConfigCategories;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregtech.worldgen.WorldgenRocks;

import static com.mayon.polytekk.data.PT_BiomeDim.GEN_EVE;
import static com.mayon.polytekk.data.PT_BiomeDim.GEN_MOHO;
import static gregapi.data.CS.F;
import static gregapi.data.CS.T;

public class Loader_Worldgen_Eve implements Runnable {

    public void run() {

        boolean
            tInfiniteOil = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteOilSources", F),
            tInfiniteGas = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteGasSources", F);

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_EVE);

        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  7000, MT.Adamantine                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.plutonium"   , T, T,  7000, MT.Pu                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.schrabidium"   , T, T,  7000, PT_Loader_Ores.Schrabidium, GEN_EVE);

    }

}
