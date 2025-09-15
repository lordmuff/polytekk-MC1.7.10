package com.mayon.polytekk.loaders.worldgen;

import gregapi.config.ConfigCategories;
import gregapi.data.CS;

import static gregapi.data.CS.F;

public class Loader_Worldgen_Ike implements Runnable {

    public void run() {

        boolean
            tInfiniteOil = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteOilSources", F),
            tInfiniteGas = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteGasSources", F);

    }

}
