package com.mayon.polytekk.worldgen;

import gregapi.block.BlockBase;
import gregapi.block.metatype.BlockStones;
import gregapi.config.ConfigCategories;
import gregapi.data.*;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.ST;
import gregapi.worldgen.*;
import gregtech.worldgen.WorldgenFluidSpring;
import gregtech.worldgen.WorldgenPit;
import gregtech.worldgen.WorldgenRocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import static gregapi.data.CS.*;

public class Loader_Worldgen_DeepDark implements Runnable {

    public void run() {

        boolean
            tInfiniteOil = ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteOilSources", T),
            tInfiniteGas = ConfigsGT.WORLDGEN.get(ConfigCategories.general, "GenerateInfiniteGasSources", T);

        new WorldgenRocks(     "deepdark.rocks"      , T, 5, 5, GEN_DEEPDARK);

        new WorldgenOresBedrock("ore.bedrock.deepdark.adamantine"   , T, T,  50000, MT.Adamantine                                , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.naquadah"     , T, T,  13500, MT.Nq                                        , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.alexandrite"     , T, T,  256000, MT.Alexandrite                                       , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.gold"       , T, T,  7500, MT.Au                  , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.russellite"    , T, T,   7200, MT.OREMATS.Russellite               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.uraninite"    , T, T,   5200, MT.OREMATS.Uraninite               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.pitchblende"    , T, T,   4000, MT.OREMATS.Pitchblende               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.saltpeter"    , T, T,   3000, MT.Niter               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.rareearth"    , T, T,   3000, MT.RareEarth               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.coal"    , T, T,   3000, MT.Coal               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.redstone"    , T, T,   3000, MT.Redstone               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.eudialyte"    , T, T,   3000, MT.Eudialyte               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.deepdark.cobaltite"    , T, T,   3000, MT.OREMATS.Cobaltite               , GEN_DEEPDARK);

        new WorldgenFluidSpring(   "deepdark.fluid.lava"          , T, Blocks.lava             ,  0, 600,                FL.Lava            .make( 10000)     , GEN_DEEPDARK);

        new WorldgenFluidSpring(   "deepdark.fluid.oil.extraheavy", T, BlocksGT.OilExtraHeavy  , 15, 600, tInfiniteOil ? FL.Oil_ExtraHeavy  .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "deepdark.fluid.oil.heavy"     , T, BlocksGT.OilHeavy       , 15, 500, tInfiniteOil ? FL.Oil_Heavy       .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "deepdark.fluid.oil.medium"    , T, BlocksGT.OilMedium      , 15, 400, tInfiniteOil ? FL.Oil_Medium      .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "deepdark.fluid.oil.light"     , T, BlocksGT.OilLight       , 15, 400, tInfiniteOil ? FL.Oil_Light       .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "deepdark.fluid.gas.natural"   , T, BlocksGT.GasNatural     , 15, 800, tInfiniteGas ? FL.Gas_Natural     .make( 9000) : NF, GEN_DEEPDARK);

        new WorldgenOresLarge("ore.large.deepdark.alexandrite", T, T, 1, 255, 1, 32, 256, MT.Emerald, MT.Alexandrite, MT.Alexandrite, MT.Diamond, ORE_DEEPDARK);

    }
}
