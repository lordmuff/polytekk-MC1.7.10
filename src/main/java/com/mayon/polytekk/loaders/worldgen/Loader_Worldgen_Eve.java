package com.mayon.polytekk.loaders.worldgen;

import com.hbm.blocks.ModBlocks;
import com.mayon.polytekk.loaders.ores.PT_Loader_Materials;
import gregapi.config.ConfigCategories;
import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregapi.worldgen.WorldgenOresLarge;
import gregtech.worldgen.WorldgenFluidSpring;
import gregtech.worldgen.WorldgenRocks;
import net.minecraft.init.Blocks;

import static com.mayon.polytekk.data.PT_BiomeDim.GEN_DRES;
import static com.mayon.polytekk.data.PT_BiomeDim.GEN_EVE;
import static gregapi.data.CS.*;
import static gregapi.data.CS.ORE_DEEPDARK;

public class Loader_Worldgen_Eve implements Runnable {

    public void run() {

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_EVE);

        new WorldgenOresBedrock("ore.bedrock.tengam"   , T, T,  24000, PT_Loader_Materials.Tengam                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  12000, MT.Adamantine                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.plutonium"   , T, T,  7000, MT.Pu                                , GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.schrabidium"   , T, T,  9000, PT_Loader_Materials.Schrabidium, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.solinium"   , T, T,  11000, PT_Loader_Materials.Solinium, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.tiberium"   , T, T,  7000, PT_Loader_Materials.Tiberium, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.zirconium"   , T, T,  4500, MT.Zr, GEN_EVE);
        new WorldgenOresBedrock("ore.bedrock.hafnium"   , T, T,  7500, MT.Hf, GEN_EVE);

        new WorldgenFluidSpring("fluid.mercury"          , T, ModBlocks.mercury_block             ,  0, 600,                MT.Hg.fluid(10000L, true)     , GEN_EVE);

        new WorldgenOresLarge("ore.large.adamantine"  , T, T, 1, 20,   6, 3, 22, MT.OREMATS.BrownLimonite        , MT.OREMATS.YellowLimonite      , MT.Fe2O3                       , MT.Adamantine         , GEN_EVE);
        new WorldgenOresLarge("ore.large.tiberium"  , T, T, 40, 255,   8, 5, 42, MT.Ruby, MT.BlueSapphire      , PT_Loader_Materials.Tiberium                       , PT_Loader_Materials.Tiberium         , GEN_EVE);
        new WorldgenOresLarge("ore.large.zircon"  , T, T, 10, 20,   18, 2, 10, MT.Zircon, MT.Zircon      , MT.Zr                       , MT.Hf         , GEN_EVE);
        new WorldgenOresLarge("ore.large.schrabidium"  , T, T, 40, 255,   12, 4, 40, MT.Pu, MT.Am      , PT_Loader_Materials.Schrabidium                       , PT_Loader_Materials.Schrabidium         , GEN_EVE);
        new WorldgenOresLarge("ore.large.schrabidium"  , T, T, 40, 255,   6, 3, 48, MT.Pu, MT.Am      , PT_Loader_Materials.Schrabidium                       , PT_Loader_Materials.Solinium         , GEN_EVE);

    }

}
