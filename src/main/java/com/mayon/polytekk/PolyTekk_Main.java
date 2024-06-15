/**
 * Copyright (c) 2023 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package com.mayon.polytekk;

import com.hbm.items.special.ItemWasteLong;
import com.hbm.items.special.ItemWasteShort;
import Reika.ChromatiCraft.ModInterface.ItemColoredModInteract;
import Reika.ChromatiCraft.Registry.CrystalElement;
import com.hbm.items.ModItems;
import com.mayon.polytekk.data.PT_ItemCont;
import com.mayon.polytekk.items.PTParticleMultiItem;
import com.mayon.polytekk.items.PT_Bumbles;
import com.mayon.polytekk.items.PT_Combs;
import com.mayon.polytekk.tileentity.multiblocks.MultiTileEntityParticleCollider;
import com.mayon.polytekk.worldgen.Loader_Worldgen_DeepDark;
import gregapi.api.example.Example_Mod;
import gregapi.block.MaterialMachines;
import gregapi.block.MaterialScoopable;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.*;
import gregapi.oredict.OreDictManager;
import gregapi.oredict.OreDictPrefix;
import gregapi.recipes.Recipe;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import gregtech.tileentity.batteries.eu.MultiTileEntityBatteryAdvEU2048;
import gregtech.tileentity.batteries.eu.MultiTileEntityBatteryEU2048;
import gregtech.tileentity.batteries.lu.MultiTileEntityBatteryLU8192;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import scala.reflect.internal.Trees;

import java.util.Collection;

import static gregapi.data.CS.*;
import static gregapi.data.MT.EnergiumCyan;
import static gregapi.data.MT.EnergiumRed;
import static gregapi.data.OP.crushedPurified;

/**
 * @author Your Name Here, also might be worth replacing that automatically generated Copyright notice with your LPGL compatible License/Name instead of mine.
 *
 * An example implementation for a Mod using my System. Copy and rename this File into your source Directory.
 *
 * If you have ANY Problems with the examples here, then you can contact me on the Forums or IRC.
 *
 * You may ask yourself why there are no imports on this File.
 * I decided to do that, so Beginners cannot mess up by choosing wrong imports when they copy and paste Stuff.
 * Also I avoided creating Variables, because people tend to copy them over for no reason, because they don't understand what they were for, and that they could be removed easily.
 *
 * Note: it is important to load after "gregapi_post".
 *
 * Note: There are NO TEXTURES contained in GT that correspond to the Examples. Those you will have to do or copy them yourself.
 *
 * uncomment the @cpw.mods.fml.common.Mod-Annotation for actual usage.
 */
@cpw.mods.fml.common.Mod(modid= PolyTekk_Main.MOD_ID, name=PolyTekk_Main.MOD_NAME, version=PolyTekk_Main.VERSION, dependencies="required-after:gregapi_post")
public final class PolyTekk_Main extends gregapi.api.Abstract_Mod {
    /** Your Mod-ID has to be LOWERCASE and without Spaces. Uppercase Chars and Spaces can create problems with Resource Packs. This is a vanilla forge "Issue". */
    public static final String MOD_ID = "polytekk";
    /** This is your Mods Name */
    public static final String MOD_NAME = "POLYTEKK";
    /** This is your Mods Version */
    public static final String VERSION = "POLYTEKK-MC1710";
    /** Contains a ModData Object for ID and Name. Doesn't have to be changed. */
    public static gregapi.code.ModData MOD_DATA = new gregapi.code.ModData(MOD_ID, MOD_NAME);

    @cpw.mods.fml.common.SidedProxy(modId = MOD_ID, clientSide = "gregapi.api.example.Example_Proxy_Client", serverSide = "gregapi.api.example.Example_Proxy_Server")
    public static gregapi.api.Abstract_Proxy PROXY;
    @Override public String getModID() {return MOD_ID;}
    @Override public String getModName() {return MOD_NAME;}
    @Override public String getModNameForLog() {return "PolyTekk";}
    @Override public gregapi.api.Abstract_Proxy getProxy() {return PROXY;}

    // Do not change these 7 Functions. Just keep them this way.
    @cpw.mods.fml.common.Mod.EventHandler public final void onPreLoad           (cpw.mods.fml.common.event.FMLPreInitializationEvent    aEvent) {onModPreInit(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onLoad              (cpw.mods.fml.common.event.FMLInitializationEvent       aEvent) {onModInit(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onPostLoad          (cpw.mods.fml.common.event.FMLPostInitializationEvent   aEvent) {onModPostInit(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onServerStarting    (cpw.mods.fml.common.event.FMLServerStartingEvent       aEvent) {onModServerStarting(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onServerStarted     (cpw.mods.fml.common.event.FMLServerStartedEvent        aEvent) {onModServerStarted(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onServerStopping    (cpw.mods.fml.common.event.FMLServerStoppingEvent       aEvent) {onModServerStopping(aEvent);}
    @cpw.mods.fml.common.Mod.EventHandler public final void onServerStopped     (cpw.mods.fml.common.event.FMLServerStoppedEvent        aEvent) {onModServerStopped(aEvent);}

    @Override
    public void onModPreInit2(cpw.mods.fml.common.event.FMLPreInitializationEvent aEvent) {

        MultiTileEntityBlock
            aMetal      = MultiTileEntityBlock.getOrCreate(MOD_ID, "iron"         , Material.iron             , Block.soundTypeMetal, TOOL_pickaxe, 0, 0, 15, F, F)
            , aMetalChips = MultiTileEntityBlock.getOrCreate(MOD_ID, "iron"         , Material.iron             , Block.soundTypeMetal, TOOL_shovel , 0, 0, 15, F, F)
            , aMetalWires = MultiTileEntityBlock.getOrCreate(MOD_ID, "machine"      , MaterialMachines.instance , Block.soundTypeMetal, TOOL_cutter , 0, 0, 15, F, F)
            , aMachine    = MultiTileEntityBlock.getOrCreate(MOD_ID, "machine"      , MaterialMachines.instance , Block.soundTypeMetal, TOOL_wrench , 0, 0, 15, F, F)
            , aWooden     = MultiTileEntityBlock.getOrCreate(MOD_ID, "wood"         , Material.wood             , Block.soundTypeWood , TOOL_axe    , 0, 0, 15, F, F)
            , aBush       = MultiTileEntityBlock.getOrCreate(MOD_ID, "leaves"       , Material.leaves           , Block.soundTypeGrass, TOOL_axe    , 0, 0, 15, F, F)
            , aStone      = MultiTileEntityBlock.getOrCreate(MOD_ID, "rock"         , Material.rock             , Block.soundTypeStone, TOOL_pickaxe, 0, 0, 15, F, F)
            , aWool       = MultiTileEntityBlock.getOrCreate(MOD_ID, "cloth"        , Material.cloth            , Block.soundTypeCloth, TOOL_shears , 0, 0, 15, F, F)
            , aTNT        = MultiTileEntityBlock.getOrCreate(MOD_ID, "tnt"          , Material.tnt              , Block.soundTypeGrass, TOOL_pickaxe, 0, 0, 15, F, F)
            , aUtilMetal  = MultiTileEntityBlock.getOrCreate(MOD_ID, "redstoneLight", Material.redstoneLight    , Block.soundTypeMetal, TOOL_pickaxe, 0, 0, 15, F, F)
            , aUtilStone  = MultiTileEntityBlock.getOrCreate(MOD_ID, "redstoneLight", Material.redstoneLight    , Block.soundTypeStone, TOOL_pickaxe, 0, 0, 15, F, F)
            , aUtilWood   = MultiTileEntityBlock.getOrCreate(MOD_ID, "redstoneLight", Material.redstoneLight    , Block.soundTypeWood , TOOL_axe    , 0, 0, 15, F, F)
            , aUtilWool   = MultiTileEntityBlock.getOrCreate(MOD_ID, "redstoneLight", Material.redstoneLight    , Block.soundTypeCloth, TOOL_shears , 0, 0, 15, F, F)
            , aHive       = MultiTileEntityBlock.getOrCreate(MOD_ID, "rock"         , MaterialScoopable.instance, Block.soundTypeWood , TOOL_scoop  , 0, 0, 15, F, F)
            ;
        // hope Greg doesn't mind if i take this xd

        new gregapi.block.multitileentity.MultiTileEntityRegistry("polytekk.multitileentity");



        new PT_Combs("polytekk", "polytekk.multiitem.combs");
        new PT_Bumbles("polytekk", "polytekk.multiitem.bumble");




        MultiTileEntityRegistry PolytekkMultiTileEntity = MultiTileEntityRegistry.getRegistry("polytekk.multitileentity");// 247
        MultiTileEntityBlock PolytekkMachineBlock = MultiTileEntityBlock.getOrCreate("polytekk", "machine", MaterialMachines.instance, net.minecraft.block.Block.soundTypeMetal, "wrench", 0, 0, 15, false, false);// 249

        PolytekkMultiTileEntity.add("Particle Collider", "Multiblock Machines", 1, 17101, MultiTileEntityParticleCollider.class, MT.Osmiridium.mToolQuality, 16, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, "gt.hardness", 12.5F, "gt.resistance", 12.5F, "gt.color", UT.Code.getRGBInt(MT.Osmiridium.fRGBaSolid), "gt.texture", "particlecollider", "gt.input", 8192, "gt.input.min", 1, "gt.input.max", 524288, "gt.energy.accepted", TD.Energy.EU, "gt.recipemap", "polytekk.recipe.particlecollider", "gt.energy.accepted.2", TD.Energy.EU, "gt.special.start.energy", true), "FFF", "FMF", "FFF", 'M', PolytekkMultiTileEntity.getItem(2), 'F', IL.FIELD_GENERATORS[5]);// 99

        PolytekkMultiTileEntity.add("Osmiridium Wall", "Multiblock Machines", 2, 17101, MultiTileEntityMultiBlockPart.class, MT.Osmiridium.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, new Object[]{"gt.hardness", 12.5F, "gt.resistance", 12.5, "gt.texture", "metalwall", "gt.designs", 7}), new Object[]{"wPP", "hPP", 'P', OP.plate.dat(MT.Osmiridium)});// 100
        PolytekkMultiTileEntity.add("Large Superconducting Coil", "Multiblock Machines", 3, 17101, MultiTileEntityMultiBlockPart.class, MT.Superconductor.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Superconductor, new Object[]{"gt.hardness", 6.0F, "gt.resistance", 6.0F, "gt.color", UT.Code.getRGBInt(MT.Superconductor.fRGBaSolid), "gt.texture", "coil", "gt.designs", 1}), new Object[]{"WWW", "WxW", "WWW", 'W', OP.wireGt04.dat(MT.Superconductor)});// 101

        PT_ItemCont.Battery_Lead_Acid_IV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[5]+")", "Batteries"                           , 4, 14013, MultiTileEntityBatteryEU2048.class, 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_Alkaline_IV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[5]+")", "Batteries"                           , 5, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_NiCd_IV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[5]+")", "Batteries"                           , 6, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_LiCoO2_IV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[5]+")", "Batteries"                           , 7, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *  64000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[7]), null, "gt:re-battery5");
        PT_ItemCont.Battery_LiMn_IV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[5]+")", "Batteries"                           , 8, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[5], NBT_CAPACITY, V[5] * 128000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[7]), null, "gt:re-battery5");

        PT_ItemCont.Battery_Lead_Acid_LUV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[6]+")", "Batteries"                           , 9, 14013, MultiTileEntityBatteryEU2048.class, 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_Alkaline_LUV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[6]+")", "Batteries"                           , 10, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_NiCd_LUV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[6]+")", "Batteries"                           , 11, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_LiCoO2_LUV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[6]+")", "Batteries"                           , 12, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *  64000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[8]), null, "gt:re-battery6");
        PT_ItemCont.Battery_LiMn_LUV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[6]+")", "Batteries"                           , 13, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[6], NBT_CAPACITY, V[6] * 128000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[8]), null, "gt:re-battery6");

        PT_ItemCont.Battery_Lead_Acid_ZPM         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[7]+")", "Batteries"                           , 14, 14013, MultiTileEntityBatteryEU2048.class, 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[7]), null, "gt:re-battery7");
        PT_ItemCont.Battery_Alkaline_ZPM          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[7]+")", "Batteries"                           , 15, 14013, MultiTileEntityBatteryEU2048.class      , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[7]), null, "gt:re-battery7");
        PT_ItemCont.Battery_NiCd_ZPM              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[7]+")", "Batteries"                           , 16, 14013, MultiTileEntityBatteryEU2048.class      , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[7]), null, "gt:re-battery7");
        PT_ItemCont.Battery_LiCoO2_ZPM            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[7]+")", "Batteries"                           , 17, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *  74000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[9]), null, "gt:re-battery7");
        PT_ItemCont.Battery_LiMn_ZPM              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[7]+")", "Batteries"                           , 18, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[7], NBT_CAPACITY, V[7] * 129000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[9]), null, "gt:re-battery7");

        PT_ItemCont.Battery_Lead_Acid_UV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[8]+")", "Batteries"                           , 19, 14013, MultiTileEntityBatteryEU2048.class, 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[8]), null, "gt:re-battery8");
        PT_ItemCont.Battery_Alkaline_UV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[8]+")", "Batteries"                           , 20, 14013, MultiTileEntityBatteryEU2048.class      , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[8]), null, "gt:re-battery8");
        PT_ItemCont.Battery_NiCd_UV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[8]+")", "Batteries"                           , 21, 14013, MultiTileEntityBatteryEU2048.class      , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[8]), null, "gt:re-battery8");
        PT_ItemCont.Battery_LiCoO2_UV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[8]+")", "Batteries"                           , 22, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *  84000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[10]), null, "gt:re-battery8");
        PT_ItemCont.Battery_LiMn_UV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[8]+")", "Batteries"                           , 23, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[8], NBT_CAPACITY, V[8] * 1210000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[10]), null, "gt:re-battery8");

        PT_ItemCont.Battery_Lead_Acid_PUV1         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[9]+")", "Batteries"                           , 24, 14013, MultiTileEntityBatteryEU2048.class, 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[9]), null, "gt:re-battery9");
        PT_ItemCont.Battery_Alkaline_PUV1          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[9]+")", "Batteries"                           , 25, 14013, MultiTileEntityBatteryEU2048.class      , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[9]), null, "gt:re-battery9");
        PT_ItemCont.Battery_NiCd_PUV1              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[9]+")", "Batteries"                           , 26, 14013, MultiTileEntityBatteryEU2048.class      , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[9]), null, "gt:re-battery9");
        PT_ItemCont.Battery_LiCoO2_PUV1            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[9]+")", "Batteries"                           , 27, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *  94000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[10]), null, "gt:re-battery9");
        PT_ItemCont.Battery_LiMn_PUV1              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[9]+")", "Batteries"                           , 28, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[9], NBT_CAPACITY, V[9] * 1210000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[4], 'C', OD_CIRCUITS[10]), null, "gt:re-battery9");

        PT_ItemCont.Crystal_Energium_Red_LUV      .set(PolytekkMultiTileEntity.add("Red Energium Crystal (T6)"                      , "Batteries"                           , 34, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumRed, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[6], NBT_CAPACITY, V[6] * 400000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', IL.Crystal_Energium_Red_IV), null, "gt:re-crystal6");
        PT_ItemCont.Crystal_Energium_Cyan_LUV     .set(PolytekkMultiTileEntity.add("Cyan Energium Crystal (T6)"                     , "Batteries"                           , 35, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumCyan, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[6], NBT_CAPACITY, V[6] * 800000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', IL.Crystal_Energium_Cyan_IV), null, "gt:re-crystal6");

        PT_ItemCont.Crystal_Energium_Red_ZPM      .set(PolytekkMultiTileEntity.add("Red Energium Crystal (T7)"                      , "Batteries"                           , 36, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumRed, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[7], NBT_CAPACITY, V[7] * 400000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Red_LUV), null, "gt:re-crystal7");
        PT_ItemCont.Crystal_Energium_Cyan_ZPM     .set(PolytekkMultiTileEntity.add("Cyan Energium Crystal (T7)"                     , "Batteries"                           , 37, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumCyan, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[7], NBT_CAPACITY, V[7] * 800000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Cyan_LUV), null, "gt:re-crystal7");

        PT_ItemCont.Crystal_Energium_Red_UV      .set(PolytekkMultiTileEntity.add("Red Energium Crystal (T8)"                      , "Batteries"                           , 38, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumRed, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[8], NBT_CAPACITY, V[8] * 400000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Red_ZPM), null, "gt:re-crystal8");
        PT_ItemCont.Crystal_Energium_Cyan_UV     .set(PolytekkMultiTileEntity.add("Cyan Energium Crystal (T8)"                     , "Batteries"                           , 39, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumCyan, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[8], NBT_CAPACITY, V[8] * 800000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Cyan_ZPM), null, "gt:re-crystal8");

        PT_ItemCont.Crystal_Energium_Red_PUV1      .set(PolytekkMultiTileEntity.add("Red Energium Crystal (T9)"                      , "Batteries"                           , 40, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumRed, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[9], NBT_CAPACITY, V[9] * 400000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Red_UV), null, "gt:re-crystal9");
        PT_ItemCont.Crystal_Energium_Cyan_PUV1     .set(PolytekkMultiTileEntity.add("Cyan Energium Crystal (T9)"                     , "Batteries"                           , 41, 14013, MultiTileEntityBatteryLU8192.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_MATERIAL, EnergiumCyan, NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_INPUT, V[9], NBT_CAPACITY, V[9] * 900000, NBT_ENERGY_ACCEPTED, TD.Energy.LU), "CC", 'C', PT_ItemCont.Crystal_Energium_Cyan_UV), null, "gt:re-crystal9");

    }

    @Override
    public void onModInit2(cpw.mods.fml.common.event.FMLInitializationEvent aEvent) {

        ArrayListNoNulls<Runnable> loaderList = new ArrayListNoNulls<>(F,

            new Loader_Worldgen_DeepDark()

            );

        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{6300}, PT_ItemCont.Comb_Rad.get(1), NF, null, OM.crushedTiny(MT.OREMATS.Uraninite, 7));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{10000, 1000, 1000}, PT_ItemCont.Comb_Actinide.get(1), NF, null, ST.make(ModItems.nugget_pu_mix, 2, 0), ST.make(ModItems.nugget_am_mix, 1, 0), ST.make(ModItems.nugget_cm_mix, 1, 0));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{10000, 1000}, PT_ItemCont.Comb_Schrabidium.get(1), NF, null, ST.make(ModItems.ingot_schraranium, 1, 0), ST.make(ModItems.nugget_schrabidium, 1, 0));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{10000, 2500, 1000}, PT_ItemCont.Comb_Xen.get(1), NF, FL.Ender.make(25), OM.crushed(MT.Nq, 1), OM.crushedTiny(MT.Nq_528, 3), OM.crushedTiny(MT.Nq_522, 1));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{5000, 5000}, PT_ItemCont.Comb_Limpid.get(1), NF, FL.XP.make(50), ST.make(ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.WHITE).getItem(), 1, 15), ST.make(ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.BLACK).getItem(), 1, 0));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{10000, 1000, 1000}, PT_ItemCont.Comb_Actinide.get(1), NF, null, ST.make(ModItems.nugget_pu_mix, 2, 0), ST.make(ModItems.nugget_am_mix, 1, 0), ST.make(ModItems.nugget_cm_mix, 1, 0));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{6666, 3333, 3333, 2222, 1111}, PT_ItemCont.Comb_Waste.get(1), NF, null, ST.make(ModItems.nuclear_waste_tiny, 1, 0), ST.make(ModItems.nuclear_waste_short, 1, ItemWasteShort.WasteClass.URANIUM235.ordinal()), ST.make(ModItems.nuclear_waste_long, 1, ItemWasteLong.WasteClass.URANIUM235.ordinal()), ST.make(ModItems.nuclear_waste_short, 1, ItemWasteShort.WasteClass.PLUTONIUM240.ordinal()), ST.make(ModItems.nuclear_waste_short, 1, ItemWasteShort.WasteClass.PLUTONIUM241.ordinal()));
        RM.Centrifuge.addRecipe1(T, 16, 64, new long[]{6666, 4444}, PT_ItemCont.Comb_Fallout.get(1), NF, null, ST.make(ModItems.nugget_co60, 1, 0), ST.make(ModItems.powder_sr90_tiny, 1, 0));

        Recipe.RecipeMap ParticleCollider = new Recipe.RecipeMap(null, "polytekk.recipe.particlecollider", "Particle Collider", null, 0L, 1L, CS.RES_PATH_GUI + "machines/Fusion", 2L, 6L, 1L, 2L, 6L, 0L, 2L, 1L, "Start: ", 1L, " EU", true, true, true, true, false, false, false);// 91

        ParticleCollider.addRecipe1(true, 8192L, 10L, new long[]{100L, 100L, 6L, 4L, 6L, 4L, 10L, 8L}, ST.tag(1L), FL.Hydrogen.make(1L), FL.Hydrogen.make(1L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L));// 269
        ParticleCollider.addRecipe1(true, 8192L, 20L, new long[]{100L, 100L, 8L, 6L, 8L, 6L, 14L, 12L}, ST.tag(1L), FL.Deuterium.make(1L), FL.Deuterium.make(1L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L));// 270
        ParticleCollider.addRecipe1(true, 8192L, 30L, new long[]{100L, 100L, 6L, 4L, 10L, 8L, 16L, 14L}, ST.tag(1L), FL.Tritium.make(1L), FL.Tritium.make(1L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L));// 271
        ParticleCollider.addRecipe1(true, 8192L, 40L, new long[]{100L, 100L, 12L, 10L, 12L, 10L, 18L, 16L}, ST.tag(1L), FL.Helium.make(1L), FL.Helium.make(1L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L));// 272
        ParticleCollider.addRecipe1(true, 32768L, 80L, new long[]{100L, 40L, 60L, 30L, 15L, 1L}, ST.tag(1L), FL.array(MT.Xe.gas(648648000L, true)), FL.array(MT.Xe.gas(6486480L, true)), PT_ItemCont.Photon.get(1L), PT_ItemCont.Neutrino.get(1L), PT_ItemCont.Anti_Neutrino.get(1L), PT_ItemCont.Higgs_Boson.get(1L));// 273

        //for (Runnable runnableList : loaderList) try {runnableList.run();} catch (Throwable e) {e.printStackTrace(ERR);}

    }

    @Override
    public void onModPostInit2(cpw.mods.fml.common.event.FMLPostInitializationEvent aEvent) {
        // Insert your PostInit Code here and not above
    }

    @Override
    public void onModServerStarting2(cpw.mods.fml.common.event.FMLServerStartingEvent aEvent) {
        // Insert your ServerStarting Code here and not above
    }

    @Override
    public void onModServerStarted2(cpw.mods.fml.common.event.FMLServerStartedEvent aEvent) {
        // Insert your ServerStarted Code here and not above
    }

    @Override
    public void onModServerStopping2(cpw.mods.fml.common.event.FMLServerStoppingEvent aEvent) {
        // Insert your ServerStopping Code here and not above
    }

    @Override
    public void onModServerStopped2(cpw.mods.fml.common.event.FMLServerStoppedEvent aEvent) {
        // Insert your ServerStopped Code here and not above
    }
}
