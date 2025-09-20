package com.mayon.polytekk.loaders.worldgen;

import gregapi.config.ConfigCategories;
import gregapi.data.CS;

import static com.mayon.polytekk.data.PT_BiomeDim.GEN_DRES;
import static com.mayon.polytekk.data.PT_BiomeDim.GEN_DUNA;
import static gregapi.data.CS.F;
import static gregapi.data.CS.T;

public class Loader_Worldgen_Duna implements Runnable {

    public void run() {

        new PT_WorldGen_CrystalOre_Rad("duna.crystals.rad", T, GEN_DUNA);
        new PT_WorldGen_CrystalOre_Isotopes_Common("duna.crystals.isotopes.common", T, GEN_DUNA);

    }

}
