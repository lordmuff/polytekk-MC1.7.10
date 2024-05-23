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
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.*;
import gregapi.recipes.Recipe;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import scala.reflect.internal.Trees;

import java.util.Collection;

import static gregapi.data.CS.*;

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

        new gregapi.block.multitileentity.MultiTileEntityRegistry("polytekk.multitileentity");



        new PT_Combs("polytekk", "polytekk.multiitem.combs");
        new PT_Bumbles("polytekk", "polytekk.multiitem.bumble");




        MultiTileEntityRegistry PolytekkMultiTileEntity = MultiTileEntityRegistry.getRegistry("polytekk.multitileentity");// 247
        MultiTileEntityBlock PolytekkMachineBlock = MultiTileEntityBlock.getOrCreate("polytekk", "machine", MaterialMachines.instance, net.minecraft.block.Block.soundTypeMetal, "wrench", 0, 0, 15, false, false);// 249

        PolytekkMultiTileEntity.add("Particle Collider", "Multiblock Machines", 1, 17101, MultiTileEntityParticleCollider.class, MT.Osmiridium.mToolQuality, 16, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, "gt.hardness", 12.5F, "gt.resistance", 12.5F, "gt.color", UT.Code.getRGBInt(MT.Osmiridium.fRGBaSolid), "gt.texture", "particlecollider", "gt.input", 8192, "gt.input.min", 1, "gt.input.max", 524288, "gt.energy.accepted", TD.Energy.EU, "gt.recipemap", "polytekk.recipe.particlecollider", "gt.energy.accepted.2", TD.Energy.EU, "gt.special.start.energy", true), "FFF", "FMF", "FFF", 'M', PolytekkMultiTileEntity.getItem(2), 'F', IL.FIELD_GENERATORS[5]);// 99

        PolytekkMultiTileEntity.add("Osmiridium Wall", "Multiblock Machines", 2, 17101, MultiTileEntityMultiBlockPart.class, MT.Osmiridium.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Osmiridium, new Object[]{"gt.hardness", 12.5F, "gt.resistance", 12.5, "gt.texture", "metalwall", "gt.designs", 7}), new Object[]{"wPP", "hPP", 'P', OP.plate.dat(MT.Osmiridium)});// 100
        PolytekkMultiTileEntity.add("Large Superconducting Coil", "Multiblock Machines", 3, 17101, MultiTileEntityMultiBlockPart.class, MT.Superconductor.mToolQuality, 64, PolytekkMachineBlock, UT.NBT.make("gt.material", MT.Superconductor, new Object[]{"gt.hardness", 6.0F, "gt.resistance", 6.0F, "gt.color", UT.Code.getRGBInt(MT.Superconductor.fRGBaSolid), "gt.texture", "coil", "gt.designs", 1}), new Object[]{"WWW", "WxW", "WWW", 'W', OP.wireGt04.dat(MT.Superconductor)});// 101

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

        //Recipe.RecipeMap ParticleCollider = new Recipe.RecipeMap(null, "polytekk.recipe.particlecollider", "Particle Collider", null, 0L, 1L, CS.RES_PATH_GUI + "machines/Fusion", 2L, 6L, 1L, 2L, 6L, 0L, 2L, 1L, "Start: ", 1L, " EU", true, true, true, true, false, false, false);// 91

        //ParticleCollider.addRecipe1(true, 8192L, 10L, new long[]{100L, 100L, 6L, 4L, 6L, 4L, 10L, 8L}, ST.tag(1L), FL.Hydrogen.make(10L), FL.Hydrogen.make(0L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L)).setSpecialNumber(10000000L);// 269
        //ParticleCollider.addRecipe1(true, 8192L, 20L, new long[]{100L, 100L, 8L, 6L, 8L, 6L, 14L, 12L}, ST.tag(1L), FL.Deuterium.make(10L), FL.Deuterium.make(0L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L)).setSpecialNumber(10000000L);// 270
        //ParticleCollider.addRecipe1(true, 8192L, 30L, new long[]{100L, 100L, 6L, 4L, 10L, 8L, 16L, 14L}, ST.tag(1L), FL.Tritium.make(10L), FL.Tritium.make(0L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L)).setSpecialNumber(10000000L);// 271
        //ParticleCollider.addRecipe1(true, 8192L, 40L, new long[]{100L, 100L, 12L, 10L, 12L, 10L, 18L, 16L}, ST.tag(1L), FL.Helium.make(10L), FL.Helium.make(0L), PT_ItemCont.Proton.get(1L), PT_ItemCont.Anti_Proton.get(1L), PT_ItemCont.Neutron.get(1L), PT_ItemCont.Anti_Neutron.get(1L), PT_ItemCont.Electron.get(1L), PT_ItemCont.Positron.get(1L)).setSpecialNumber(10000000L);// 272
        //ParticleCollider.addRecipe1(true, 32768L, 80L, new long[]{100L, 40L, 60L, 30L, 15L, 1L}, ST.tag(1L), FL.array(MT.Xe.gas(648648000L, true)), FL.array(MT.Xe.gas(6486480L, true)), PT_ItemCont.Photon.get(1L), PT_ItemCont.Neutrino.get(1L), PT_ItemCont.Anti_Neutrino.get(1L), PT_ItemCont.Higgs_Boson.get(1L)).setSpecialNumber(10000000L);// 273

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
