package com.mayon.polytekk.loaders.worldgen;

import gregapi.config.ConfigCategories;
import gregapi.data.CS;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregapi.worldgen.WorldgenOresLarge;
import gregapi.worldgen.WorldgenOresSmall;
import gregtech.worldgen.WorldgenFluidSpring;
import gregtech.worldgen.WorldgenRocks;
import net.minecraft.init.Blocks;

import static com.mayon.polytekk.data.PT_BiomeDim.*;
import static gregapi.data.CS.*;

public class Loader_Worldgen_Moho implements Runnable {

    public void run() {

        boolean
            tInfiniteOil = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteOilSources", F),
            tInfiniteGas = CS.ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteGasSources", F);

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_MOHO);

        new WorldgenOresBedrock("ore.bedrock.tantalite"      , T, T, 16000, MT.OREMATS.Tantalite             , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.hafnium"      , T, T, 16000, MT.Hf             , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.arsenic"      , T, T, 7600, MT.As             , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.firestone"      , T, T, 8000, MT.Firestone             , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  14000, MT.Adamantine                                , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.sheldonite"       , T, T,  5555, MT.OREMATS.Cooperite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.sperrylite"       , T, T,  6767, MT.OREMATS.Sperrylite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.pentlandite"       , T, T,  2333, MT.OREMATS.Pentlandite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.gold"       , T, T,  2333, MT.Au                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.limonite.1"       , T, T,  2000, MT.OREMATS.BrownLimonite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.limonite.2"       , T, T,  2000, MT.OREMATS.YellowLimonite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.tungstate"       , T, T,  3333, MT.OREMATS.Tungstate                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.borax"       , T, T,  3333, MT.OREMATS.Borax                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.chromite"       , T, T,  2333, MT.OREMATS.Chromite                  , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.quartz"       , T, T,  2000, MT.NetherQuartz                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.cobaltite"       , T, T,  1111, MT.OREMATS.Cobaltite                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.mineralsand.1"       , T, T,  1111, MT.OREMATS.BasalticMineralSand                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.mineralsand.2"       , T, T,  1111, MT.OREMATS.GraniticMineralSand                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.netherite"       , T, T,  18000, MT.AncientDebris                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.redstone"       , T, T,  2222, MT.Redstone                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.saltpeter"       , T, T,  2000, MT.Niter                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.phosphorus.1"       , T, T,  4444, MT.PhosphorusRed                 , GEN_MOHO);
        new WorldgenOresBedrock("ore.bedrock.phosphorus.2"       , T, T,  5454, MT.PhosphorusWhite                 , GEN_MOHO);

        new WorldgenFluidSpring(   "fluid.lava"          , T, Blocks.lava             ,  0, 200,                FL.Lava            .make( 10000)     , GEN_MOHO);

        new WorldgenOresLarge("ore.large.bismoid"        , T, T, 1,  40,   30, 9, 26, MT.Bi       , MT.As                 , MT.Au        , MT.Cu                 , GEN_MOHO);

        new WorldgenOresSmall("ore.small.gold"           , T,  1, 55,  612, MT.Au                  , GEN_MOHO);
        new WorldgenOresSmall("ore.small.bismuth"           , T,  1, 20,  555, MT.Bi                  , GEN_MOHO);
        new WorldgenOresSmall("ore.small.sperrylite"           , T,  1, 55,  777, MT.OREMATS.Sperrylite                  , GEN_MOHO);
        new WorldgenOresSmall("ore.small.cooperite"           , T,  1, 55,  777, MT.OREMATS.Cooperite                  , GEN_MOHO);

    }

}
