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

        new WorldgenRocks(     "rocks"      , T, 5, 5, GEN_DEEPDARK);

        new WorldgenOresBedrock("ore.bedrock.adamantine"   , T, T,  50000, MT.Adamantine                                , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.naquadah"     , T, T,  13500, MT.Nq                                        , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.alexandrite"     , T, T,  256000, MT.Alexandrite                                       , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.gold"       , T, T,  7500, MT.Au                  , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.russellite"    , T, T,   7200, MT.OREMATS.Russellite               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.uraninite"    , T, T,   5200, MT.OREMATS.Uraninite               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.pitchblende"    , T, T,   4000, MT.OREMATS.Pitchblende               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.saltpeter"    , T, T,   3000, MT.Niter               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.rareearth"    , T, T,   3000, MT.RareEarth               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.coal"    , T, T,   3000, MT.Coal               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.redstone"    , T, T,   3000, MT.Redstone               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.eudialyte"    , T, T,   3000, MT.Eudialyte               , GEN_DEEPDARK);
        new WorldgenOresBedrock("ore.bedrock.cobaltite"    , T, T,   3000, MT.OREMATS.Cobaltite               , GEN_DEEPDARK);

        new WorldgenFluidSpring(   "fluid.lava"          , T, Blocks.lava             ,  0, 600,                FL.Lava            .make( 10000)     , GEN_DEEPDARK);

        new WorldgenFluidSpring(   "fluid.oil.extraheavy", T, BlocksGT.OilExtraHeavy  , 15, 600, tInfiniteOil ? FL.Oil_ExtraHeavy  .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "fluid.oil.heavy"     , T, BlocksGT.OilHeavy       , 15, 500, tInfiniteOil ? FL.Oil_Heavy       .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "fluid.oil.medium"    , T, BlocksGT.OilMedium      , 15, 400, tInfiniteOil ? FL.Oil_Medium      .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "fluid.oil.light"     , T, BlocksGT.OilLight       , 15, 400, tInfiniteOil ? FL.Oil_Light       .make( 12000) : NF, GEN_DEEPDARK);
        new WorldgenFluidSpring(   "fluid.gas.natural"   , T, BlocksGT.GasNatural     , 15, 800, tInfiniteGas ? FL.Gas_Natural     .make( 9000) : NF, GEN_DEEPDARK);

        new WorldgenOresLarge("ore.large.alexandrite", T, T, 1, 255, 1, 32, 256, MT.Emerald, MT.Diamond, MT.Alexandrite, MT.Alexandrite, ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.tetrahedrite", T, T, 1, 255, 150, 4, 48, MT.OREMATS.Tetrahedrite         , MT.OREMATS.Tetrahedrite        , MT.Cu                          , MT.OREMATS.Stibnite   , ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.uraninite", T, T, 1, 255, 80, 6, 32, MT.Pb, MT.OREMATS.Uraninite, MT.OREMATS.Uraninite, MT.Ra, ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.pitchblende", T, T, 1, 255, 80, 6, 32, MT.Pb, MT.OREMATS.Pitchblende, MT.OREMATS.Pitchblende, MT.Ra, ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.gold"        , T, T, 1,  255,   60, 4, 32, MT.Pyrite                       , MT.OREMATS.Chalcopyrite        , MT.OREMATS.Arsenopyrite        , MT.Au                 , ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.adamantium"  , T, T, 1, 255,   5, 3, 24, MT.OREMATS.BrownLimonite        , MT.OREMATS.YellowLimonite      , MT.Fe2O3                       , MT.Adamantine         , ORE_DEEPDARK);
        new WorldgenOresLarge("ore.large.naquadah"    , T, T, 1,  255,  18, 7, 76, MT.Nq                           , MT.Nq                          , MT.Nq_522                          , MT.Nq_528                 , ORE_DEEPDARK);

        new WorldgenOresSmall("ore.small.lead"           , T,  1, 255,  512, MT.Pb                 , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.copper"           , T,  1, 255,  512, MT.Cu                 , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.chalcopyrite"           , T,  1, 255,  256, MT.OREMATS.Chalcopyrite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.cassiterite"           , T,  1, 255,  256, MT.OREMATS.Cassiterite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.sphalerite"           , T,  1, 255,  128, MT.OREMATS.Sphalerite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.stibnite"           , T,  1, 255,  128, MT.OREMATS.Stibnite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.galena"           , T,  1, 255,  128, MT.OREMATS.Galena                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.arsenopyrite"           , T,  1, 255,  128, MT.OREMATS.Arsenopyrite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.garnierite"           , T,  1, 255,  128, MT.OREMATS.Garnierite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.borax"           , T,  1, 255,  128, MT.OREMATS.Borax                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.coltan"           , T,  1, 255,  64, MT.OREMATS.Coltan                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.columbite"           , T,  1, 255,  64, MT.OREMATS.Columbite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.tantalite"           , T,  1, 255,  64, MT.OREMATS.Tantalite                  , GEN_DEEPDARK);
        new WorldgenOresSmall("ore.small.gold"           , T,  1, 255,  48, MT.Au                  , GEN_DEEPDARK);

    }
}
