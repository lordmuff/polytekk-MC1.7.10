package com.mayon.polytekk.loaders.worldgen;

import static gregapi.data.CS.*;

public class Loader_Worldgen_Misc  implements Runnable {

    public void run() {

        new PT_WorldGen_CrystalOre_Magic("twilight.crystals.magic", T, GEN_TWILIGHT);
        new PT_WorldGen_CrystalOre_Hot("nether.crystals.hot", T, GEN_NETHER);

    }

}
