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

import com.hbm.blocks.ModBlocks;
import com.hbm.items.special.ItemWasteLong;
import com.hbm.items.special.ItemWasteShort;
import Reika.ChromatiCraft.ModInterface.ItemColoredModInteract;
import Reika.ChromatiCraft.Registry.CrystalElement;
import com.hbm.items.ModItems;
import com.mayon.polytekk.data.PT_ItemCont;
import com.mayon.polytekk.items.PT_Bumbles;
import com.mayon.polytekk.items.PT_Combs;
import com.mayon.polytekk.loaders.ores.PT_Loader_Materials;
import com.mayon.polytekk.loaders.worldgen.*;
import com.mayon.polytekk.tileentity.multiblocks.MultiTileEntityParticleCollider;
import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.*;
import gregapi.recipes.Recipe;
import gregapi.render.BlockTextureCopied;
import gregapi.render.TextureSet;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import gregtech.tileentity.batteries.eu.MultiTileEntityBatteryAdvEU2048;
import gregtech.tileentity.batteries.eu.MultiTileEntityBatteryEU2048;
import gregtech.tileentity.batteries.lu.MultiTileEntityBatteryLU8192;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import static gregapi.data.CS.*;
import static gregapi.data.CS.F;
import static gregapi.data.CS.T;
import static gregapi.data.CS.V;
import static gregapi.data.MT.*;
import static gregapi.data.OP.dust;
import static gregapi.data.OP.oreMoon;
import static gregapi.data.TD.Prefix.*;
import static gregtech.loaders.a.Loader_Ores.rockset;

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

    @cpw.mods.fml.common.SidedProxy(modId = MOD_ID, clientSide = "gregapi.api.example.Example_Proxy_Client", serverSide = "polytekk.PolyTekk_Server_Proxy")
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
            aUtilMetal  = MultiTileEntityBlock.getOrCreate(MOD_ID, "redstoneLight", Material.redstoneLight    , Block.soundTypeMetal, TOOL_pickaxe, 0, 0, 15, F, F)
           ;
        // hope Greg doesn't mind if i take this xd

        PT_Loader_Materials.StoneMoho.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneEve.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneMinmus.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneDuna.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneDres.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneIke.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneLaythe.setTextures(TextureSet.SET_STONE);
        PT_Loader_Materials.StoneTekto.setTextures(TextureSet.SET_STONE);

        PT_Loader_Materials.Tiberium.setTextures(TextureSet.SET_GEM_HORIZONTAL);

        PT_Loader_Materials.Australium.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Schrabidium.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Solinium.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Euphemium.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Pb_209.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Bk_247.setTextures(TextureSet.SET_RAD);
        PT_Loader_Materials.Es_253.setTextures(TextureSet.SET_RAD);

        PT_Loader_Materials.StoneMoho.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneEve.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneMinmus.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneDuna.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneDres.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneIke.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneLaythe.put(gregapi.data.TD.Processing.CENTRIFUGE);
        PT_Loader_Materials.StoneTekto.put(gregapi.data.TD.Processing.CENTRIFUGE);

        PT_Loader_Materials.StoneMoho.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneEve.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneMinmus.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneDuna.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneDres.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneIke.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneLaythe.put(gregapi.data.TD.Processing.ELECTROLYSER);
        PT_Loader_Materials.StoneTekto.put(gregapi.data.TD.Processing.ELECTROLYSER);

        PT_Loader_Materials.StoneMoho.heat(STONES.MercuryRock.mMeltingPoint, STONES.MercuryRock.mBoilingPoint);
        PT_Loader_Materials.StoneEve.heat(STONES.VenusRock.mMeltingPoint, STONES.VenusRock.mBoilingPoint);
        PT_Loader_Materials.StoneMinmus.heat(Ice.mMeltingPoint + 23, Ice.mBoilingPoint + 23);
        PT_Loader_Materials.StoneDuna.heat(STONES.MarsRock.mMeltingPoint, STONES.MarsRock.mBoilingPoint);
        PT_Loader_Materials.StoneDres.heat(STONES.PhobosRock.mMeltingPoint, STONES.PhobosRock.mBoilingPoint);
        PT_Loader_Materials.StoneIke.heat(STONES.Basalt.mMeltingPoint + 444, STONES.Basalt.mBoilingPoint + 444);
        PT_Loader_Materials.StoneLaythe.heat(STONES.Limestone.mMeltingPoint + 444, STONES.Limestone.mBoilingPoint + 444);
        PT_Loader_Materials.StoneTekto.heat(PVC.mMeltingPoint + 50, PVC.mBoilingPoint + 75);

        PT_Loader_Materials.StoneMoho.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneEve.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneMinmus.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneDuna.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneDres.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneIke.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneLaythe.setOriginalMod(MD.HBM);
        PT_Loader_Materials.StoneTekto.setOriginalMod(MD.HBM);

        PT_Loader_Materials.Australium.setOriginalMod(MD.HBM);
        PT_Loader_Materials.Schrabidium.setOriginalMod(MD.HBM);
        PT_Loader_Materials.Solinium.setOriginalMod(MD.HBM);
        PT_Loader_Materials.Euphemium.setOriginalMod(MD.HBM);
        PT_Loader_Materials.Pb_209.setOriginalMod(MD.HBM);

        PT_Loader_Materials.Volcanic.heat(NetherizedDiamond.mMeltingPoint + 400, NetherizedDiamond.mBoilingPoint + 750);
        PT_Loader_Materials.Molysite.heat(Sodalite.mMeltingPoint + 375, Sodalite.mBoilingPoint + 575);
        PT_Loader_Materials.Chlorocalcite.heat(FluoriteWhite.mMeltingPoint + 375, FluoriteWhite.mBoilingPoint + 575);
        PT_Loader_Materials.Australium.heat(Au_198.mMeltingPoint - 300, Au_198.mBoilingPoint - 450);
        PT_Loader_Materials.Schrabidium.heat(Nq.mMeltingPoint - 300, Nq.mBoilingPoint - 450);
        PT_Loader_Materials.Solinium.heat(Nq_522.mMeltingPoint - 300, Nq_522.mBoilingPoint - 450);
        PT_Loader_Materials.Euphemium.heat(Nq_528.mMeltingPoint - 400, Nq_528.mBoilingPoint - 750);
        PT_Loader_Materials.Pb_209.heat(Pb.mMeltingPoint - 50, Pb.mBoilingPoint - 150);
        PT_Loader_Materials.Bk_247.heat(Bk.mMeltingPoint, Bk.mBoilingPoint);
        PT_Loader_Materials.Es_253.heat(Es.mMeltingPoint, Es.mBoilingPoint);

        PT_Loader_Materials.Chlorocalcite.ores(CaCO3, LiCl, NaCl, PT_Loader_Materials.Chlorocalcite);
        PT_Loader_Materials.Molysite.ores(Sodalite, FeCl2, FeCl3, NaCl, PT_Loader_Materials.Molysite);
        PT_Loader_Materials.Volcanic.ores(Firestone, InfusedFire, PhosphorusRed, PhosphorusWhite, PT_Loader_Materials.Molysite, PT_Loader_Materials.Volcanic);
        PT_Loader_Materials.Australium.ores(Au, Au_198, Ag, PT_Loader_Materials.Pb_209);
        PT_Loader_Materials.Schrabidium.ores(Pu, OREMATS.Uraninite, PT_Loader_Materials.Solinium);
        PT_Loader_Materials.Solinium.ores(PT_Loader_Materials.Euphemium, Pu, Pu, Cm, Am);
        PT_Loader_Materials.Euphemium.ores(PT_Loader_Materials.Solinium, PT_Loader_Materials.Schrabidium, Nq_522, Nq_528, Nq);
        PT_Loader_Materials.Tiberium.ores(PT_Loader_Materials.Tiberium, Nq, Nq, Nq_528, Nq_522, Ta);

        PT_Loader_Materials.Tiberium.aspects(TC.RADIO, 4).aspects(TC.VITREUS, 2);
        PT_Loader_Materials.Australium.aspects_met_rad(2, 4).aspects(TC.LUCRUM, 2);
        PT_Loader_Materials.Schrabidium.aspects_met_rad(1, 5).aspects(TC.PERMUTATIO, 2).aspects(TC.POTENTIA, 1);
        PT_Loader_Materials.Solinium.aspects_met_rad(2, 6).aspects(TC.PERMUTATIO, 1).aspects(TC.POTENTIA, 2);
        PT_Loader_Materials.Euphemium.aspects_met_rad(1, 7).aspects(TC.NEBRISUM, 2).aspects(TC.LUCRUM, 2);
        PT_Loader_Materials.Pb_209.aspects_met_rad(3, 13).aspects(TC.NEBRISUM, 1).aspects(TC.ORDO, 1);
        PT_Loader_Materials.Bk_247.aspects_met_rad(5, 6).aspects(TC.NEBRISUM, 2);
        PT_Loader_Materials.Es_253.aspects_met_rad(5, 23).aspects(TC.NEBRISUM, 3);

        PT_Loader_Materials.Tengam.setRGBa(160, 191,  96, 255);
        PT_Loader_Materials.Tiberium.setRGBa(10, 255,  10, 255);

        PT_Loader_Materials.Australium.setRGBa(255, 238, 0 ,255);
        PT_Loader_Materials.Schrabidium.setRGBa(0, 189, 189,255);
        PT_Loader_Materials.Solinium.setRGBa(0, 230, 224,255);
        PT_Loader_Materials.Euphemium.setRGBa(230, 77, 160,255);
        PT_Loader_Materials.Pb_209.setRGBa(179, 138, 148,255);
        PT_Loader_Materials.Bk_247.setRGBa(206, 202, 205,255);
        PT_Loader_Materials.Es_253.setRGBa(193, 198, 186,255);

        PT_Loader_Materials.StoneMoho.setRGBa(89, 64, 48,255);
        PT_Loader_Materials.StoneEve.setRGBa(75, 65, 130,255);
        PT_Loader_Materials.StoneMinmus.setRGBa(82, 53, 13,255);
        PT_Loader_Materials.StoneDuna.setRGBa(131, 69, 52,255);
        PT_Loader_Materials.StoneDres.setRGBa(67, 67, 67,255);
        PT_Loader_Materials.StoneIke.setRGBa(136, 134, 134,255);
        PT_Loader_Materials.StoneLaythe.setRGBa(172, 8, 0,255);
        PT_Loader_Materials.StoneTekto.setRGBa(52, 64, 58,255);

        PT_Loader_Materials.StoneMoho.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneEve.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneMinmus.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneDuna.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneDres.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneIke.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneLaythe.put(gregapi.data.TD.ItemGenerator.G_DUST);
        PT_Loader_Materials.StoneTekto.put(gregapi.data.TD.ItemGenerator.G_DUST);

        PT_Loader_Materials.Australium.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE_ORES);
        PT_Loader_Materials.Schrabidium.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE_ORES);
        PT_Loader_Materials.Solinium.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE);
        PT_Loader_Materials.Euphemium.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE_ORES);
        PT_Loader_Materials.Pb_209.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE);
        PT_Loader_Materials.Bk_247.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE);
        PT_Loader_Materials.Es_253.put(gregapi.data.TD.ItemGenerator.G_INGOT_MACHINE);

        PT_Loader_Materials.Tiberium.setOriginalMod(MD.GT5U);
        PT_Loader_Materials.Tengam.setOriginalMod(MD.GT5U);


        final gregapi.oredict.OreDictPrefix oreMoho = gregapi.oredict.OreDictPrefix.createPrefix("oreMoho").setLocalItemName("Moho ", " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.IGNIS, 2).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreEve = gregapi.oredict.OreDictPrefix.createPrefix("oreEve").setLocalItemName("Eve ", " Ore").setOreStats( 4*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.VENEMUM, 2).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreMinmus = gregapi.oredict.OreDictPrefix.createPrefix("oreMinmus").setLocalItemName("Minmus ", " Ore").setOreStats( 2*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.GELUM, 2).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreDuna = gregapi.oredict.OreDictPrefix.createPrefix("oreDuna").setLocalItemName("Duna ", " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.METALLUM, 1).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreDres = gregapi.oredict.OreDictPrefix.createPrefix("oreDres").setLocalItemName("Dres ", " Ore").setOreStats( 4*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.NEBRISUM, 1).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreIke = gregapi.oredict.OreDictPrefix.createPrefix("oreIke").setLocalItemName("Ike ", " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.RADIO, 1).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreLaythe = gregapi.oredict.OreDictPrefix.createPrefix("oreLaythe").setLocalItemName("Laythe ", " Ore").setOreStats( 5*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.FAMES, 1).setTextureSetName("ore");
        final gregapi.oredict.OreDictPrefix oreTekto = gregapi.oredict.OreDictPrefix.createPrefix("oreTekto").setLocalItemName("Tekto ", " Ore").setOreStats( 5*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.FABRICO, 1).setTextureSetName("ore");

        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.moho", oreMoho, null, null, null, BlockTextureCopied.get(ModBlocks.moho_stone), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.eve", oreEve, null, null, null, BlockTextureCopied.get(ModBlocks.eve_rock), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.minmus", oreMinmus, null, null, null, BlockTextureCopied.get(ModBlocks.minmus_stone), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.duna", oreDuna, null, null, null, BlockTextureCopied.get(ModBlocks.duna_rock), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.dres", oreDres, null, null, null, BlockTextureCopied.get(ModBlocks.dres_rock), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.ike", oreIke, null, null, null, BlockTextureCopied.get(ModBlocks.ike_stone), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeStone, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.laythe", oreLaythe, null, null, null, BlockTextureCopied.get(ModBlocks.flesh_block), net.minecraft.block.material.Material.rock, Block.soundTypeSnow, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);
        new gregapi.block.prefixblock.PrefixBlock_(MOD_ID, MOD_ID, "pt.meta.ore.normal.tekto", oreTekto, null, null, null, BlockTextureCopied.get(ModBlocks.rubber_silt), net.minecraft.block.material.Material.rock, net.minecraft.block.Block.soundTypeSand, gregapi.data.CS.TOOL_pickaxe, 1.5F, 4.5F,   0,   0, 999, 0, 0, 0, 1, 1, 1, false, false, false, false, true, true, true, true, true, true, false, true, true, true, gregapi.oredict.OreDictMaterial.MATERIAL_ARRAY);

        oreMoho                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneMoho     , dust.mAmount * 4));
        oreEve                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneEve     , dust.mAmount * 4));
        oreMinmus                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneMinmus     , dust.mAmount * 4));
        oreDuna                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneDuna     , dust.mAmount * 4));
        oreDres                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneDres     , dust.mAmount * 4));
        oreIke                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneIke     , dust.mAmount * 4));
        oreLaythe                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneLaythe     , dust.mAmount * 4));
        oreTekto                 .mByProducts.add(OM.stack(PT_Loader_Materials.StoneTekto     , dust.mAmount * 4));

        rockset(MD.HBM,"tile.moho_stone"                  , 0, "hbm.moho.rock"         , oreMoho              , PT_Loader_Materials.StoneMoho);
        rockset(MD.HBM,"tile.eve_rock"                  , 0, "hbm.eve.rock"         , oreEve              , PT_Loader_Materials.StoneEve);
        rockset(MD.HBM,"tile.minmus_stone"                  , 0, "hbm.minmus.rock"         , oreMinmus              , PT_Loader_Materials.StoneMinmus);
        rockset(MD.HBM,"tile.moon_rock"                  , 0, "hbm.mun.rock"         , oreMoon              , MT.STONES.MoonRock);
        rockset(MD.HBM,"tile.duna_rock"                  , 0, "hbm.duna.rock"         , oreDuna              , PT_Loader_Materials.StoneDuna);
        rockset(MD.HBM,"tile.dres_rock"                  , 0, "hbm.dres.rock"         , oreDres              , PT_Loader_Materials.StoneDres);
        rockset(MD.HBM,"tile.ike_stone"                  , 0, "hbm.ike.rock"         , oreIke              , PT_Loader_Materials.StoneIke);
        rockset(MD.HBM,"stone"                  , 0, "hbm.laythe.rock"         , oreLaythe              , PT_Loader_Materials.StoneLaythe);
        rockset(MD.HBM,"stone"                  , 0, "hbm.tekto.rock"         , oreTekto              , PT_Loader_Materials.StoneTekto);


        new gregapi.block.multitileentity.MultiTileEntityRegistry("polytekk.multitileentity");



        new PT_Combs("polytekk", "polytekk.multiitem.combs");
        new PT_Bumbles("polytekk", "polytekk.multiitem.bumble");




        MultiTileEntityRegistry PolytekkMultiTileEntity = MultiTileEntityRegistry.getRegistry("polytekk.multitileentity");// 247
        MultiTileEntityBlock PolytekkMachineBlock = MultiTileEntityBlock.getOrCreate("polytekk", "machine", MaterialMachines.instance, net.minecraft.block.Block.soundTypeMetal, "wrench", 0, 0, 15, false, false);// 249

        PolytekkMultiTileEntity.add("Particle Collider", "Multiblock Machines", 1, 17101, MultiTileEntityParticleCollider.class, MT.Osmiridium.mToolQuality, 16, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, "gt.hardness", 12.5F, "gt.resistance", 12.5F, "gt.color", UT.Code.getRGBInt(MT.Osmiridium.fRGBaSolid), "gt.texture", "particlecollider", "gt.input", 8192, "gt.input.min", 1, "gt.input.max", 524288, "gt.energy.accepted", TD.Energy.EU, "gt.recipemap", "polytekk.recipe.particlecollider", "gt.energy.accepted.2", TD.Energy.EU, "gt.special.start.energy", true), "FFF", "FMF", "FFF", 'M', PolytekkMultiTileEntity.getItem(2), 'F', IL.FIELD_GENERATORS[5]);// 99

        PolytekkMultiTileEntity.add("Osmiridium Wall", "Multiblock Machines", 2, 17101, MultiTileEntityMultiBlockPart.class, MT.Osmiridium.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, new Object[]{"gt.hardness", 12.5F, "gt.resistance", 12.5, "gt.texture", "metalwall", "gt.designs", 7}), new Object[]{"wPP", "hPP", 'P', OP.plate.dat(MT.Osmiridium)});// 100
        PolytekkMultiTileEntity.add("Large Superconducting Coil", "Multiblock Machines", 3, 17101, MultiTileEntityMultiBlockPart.class, MT.Superconductor.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Superconductor, new Object[]{"gt.hardness", 6.0F, "gt.resistance", 6.0F, "gt.color", UT.Code.getRGBInt(MT.Superconductor.fRGBaSolid), "gt.texture", "coil", "gt.designs", 1}), new Object[]{"WWW", "WxW", "WWW", 'W', OP.wireGt04.dat(MT.Superconductor)});// 101

        PT_ItemCont.Battery_Lead_Acid_IV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[5]+")", "Batteries"                           , 4, 14013, MultiTileEntityBatteryEU2048.class, 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[6], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_Alkaline_IV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[5]+")", "Batteries"                           , 5, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[6], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_NiCd_IV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[5]+")", "Batteries"                           , 6, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[6], 'C', OD_CIRCUITS[5]), null, "gt:re-battery5");
        PT_ItemCont.Battery_LiCoO2_IV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[5]+")", "Batteries"                           , 7, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[5], NBT_CAPACITY, V[5] *  64000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery5");
        PT_ItemCont.Battery_LiMn_IV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[5]+")", "Batteries"                           , 8, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.5F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[5], NBT_CAPACITY, V[5] * 128000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery5");

        PT_ItemCont.Battery_Lead_Acid_LUV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[6]+")", "Batteries"                           , 9, 14013, MultiTileEntityBatteryEU2048.class, 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_04[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_Alkaline_LUV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[6]+")", "Batteries"                           , 10, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_04[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_NiCd_LUV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[6]+")", "Batteries"                           , 11, 14013, MultiTileEntityBatteryEU2048.class      , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_04[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_LiCoO2_LUV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[6]+")", "Batteries"                           , 12, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[6], NBT_CAPACITY, V[6] *  64000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_04[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");
        PT_ItemCont.Battery_LiMn_LUV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[6]+")", "Batteries"                           , 13, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 16, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.6F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[6], NBT_CAPACITY, V[6] * 128000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_04[6], 'C', OD_CIRCUITS[6]), null, "gt:re-battery6");

        PT_ItemCont.Battery_Lead_Acid_ZPM         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[7]+")", "Batteries"                           , 14, 14013, MultiTileEntityBatteryEU2048.class, 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery7");
        PT_ItemCont.Battery_Alkaline_ZPM          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[7]+")", "Batteries"                           , 15, 14013, MultiTileEntityBatteryEU2048.class      , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery7");
        PT_ItemCont.Battery_NiCd_ZPM              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[7]+")", "Batteries"                           , 16, 14013, MultiTileEntityBatteryEU2048.class      , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery7");
        PT_ItemCont.Battery_LiCoO2_ZPM            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[7]+")", "Batteries"                           , 17, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[7], NBT_CAPACITY, V[7] *  74000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery7");
        PT_ItemCont.Battery_LiMn_ZPM              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[7]+")", "Batteries"                           , 18, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 17, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.7F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[7], NBT_CAPACITY, V[7] * 129000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery7");

        PT_ItemCont.Battery_Lead_Acid_UV         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[8]+")", "Batteries"                           , 19, 14013, MultiTileEntityBatteryEU2048.class, 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_04[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery8");
        PT_ItemCont.Battery_Alkaline_UV          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[8]+")", "Batteries"                           , 20, 14013, MultiTileEntityBatteryEU2048.class      , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_04[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery8");
        PT_ItemCont.Battery_NiCd_UV              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[8]+")", "Batteries"                           , 21, 14013, MultiTileEntityBatteryEU2048.class      , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_04[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery8");
        PT_ItemCont.Battery_LiCoO2_UV            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[8]+")", "Batteries"                           , 22, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[8], NBT_CAPACITY, V[8] *  84000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_04[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery8");
        PT_ItemCont.Battery_LiMn_UV              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[8]+")", "Batteries"                           , 23, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 18, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.8F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[8], NBT_CAPACITY, V[8] * 1210000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_04[7], 'C', OD_CIRCUITS[6]), null, "gt:re-battery8");

        PT_ItemCont.Battery_Lead_Acid_PUV1         .set(PolytekkMultiTileEntity.add("Lead-Acid Battery ("                  +VN[9]+")", "Batteries"                           , 24, 14013, MultiTileEntityBatteryEU2048.class, 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Orange]                     , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   2000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Lead_Acid_Cell_Filled, 'W', MT.DATA.CABLES_01[12], 'C', OD_CIRCUITS[6]), null, "gt:re-battery9");
        PT_ItemCont.Battery_Alkaline_PUV1          .set(PolytekkMultiTileEntity.add("Alkaline Battery ("                   +VN[9]+")", "Batteries"                           , 25, 14013, MultiTileEntityBatteryEU2048.class      , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_Alkaline_Cell_Filled, 'W', MT.DATA.CABLES_01[12], 'C', OD_CIRCUITS[6]), null, "gt:re-battery9");
        PT_ItemCont.Battery_NiCd_PUV1              .set(PolytekkMultiTileEntity.add("Nickel-Cadmium Battery ("             +VN[9]+")", "Batteries"                           , 26, 14013, MultiTileEntityBatteryEU2048.class      , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Lime]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *   4000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_NiCd_Cell_Filled, 'W', MT.DATA.CABLES_01[12], 'C', OD_CIRCUITS[6]), null, "gt:re-battery9");
        PT_ItemCont.Battery_LiCoO2_PUV1            .set(PolytekkMultiTileEntity.add("Lithium-Cobalt Battery ("             +VN[9]+")", "Batteries"                           , 27, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Blue]                       , NBT_INPUT, V[9], NBT_CAPACITY, V[9] *  94000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiCoO2_Cell_Filled, 'W', MT.DATA.CABLES_01[12], 'C', OD_CIRCUITS[6]), null, "gt:re-battery9");
        PT_ItemCont.Battery_LiMn_PUV1              .set(PolytekkMultiTileEntity.add("Lithium-Manganese Battery ("          +VN[9]+")", "Batteries"                           , 28, 14013, MultiTileEntityBatteryAdvEU2048.class   , 0, 19, aUtilMetal , UT.NBT.make(NBT_HARDNESS,   0.9F, NBT_RESISTANCE,   3.0F, NBT_COLOR, DYES_INT[DYE_INDEX_Green]                      , NBT_INPUT, V[9], NBT_CAPACITY, V[9] * 1210000, NBT_ENERGY_ACCEPTED, TD.Energy.EU), "WPW", "BCB", "BBB", 'P', OP.plate.dat(MT.BatteryAlloy), 'B', IL.Battery_LiMn_Cell_Filled, 'W', MT.DATA.CABLES_01[12], 'C', OD_CIRCUITS[6]), null, "gt:re-battery9");

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

            new Loader_Worldgen_DeepDark(),
            new Loader_Worldgen_Moho(),
            new Loader_Worldgen_Eve(),
            new Loader_Worldgen_Mun(),
            new Loader_Worldgen_Minmus(),
            new Loader_Worldgen_Duna(),
            new Loader_Worldgen_Ike(),
            new Loader_Worldgen_Dres(),
            new Loader_Worldgen_Laythe(),
            new Loader_Worldgen_Tekto()

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

        for (Runnable runnableList : loaderList) try {runnableList.run();} catch (Throwable e) {e.printStackTrace(ERR);}

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
