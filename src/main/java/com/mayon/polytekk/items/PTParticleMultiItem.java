//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mayon.polytekk.items;

import static gregapi.data.CS.*;

import com.mayon.polytekk.data.PT_ItemCont;
import gregapi.code.ItemStackContainer;
import gregapi.cover.covers.*;
import gregapi.data.*;
import gregapi.data.CS.BooksGT;
import gregapi.data.CS.ItemsGT;
import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandom;
import gregapi.item.multiitem.behaviors.Behavior_Turn_Into;
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.CR;
import gregapi.util.OM;
import gregapi.util.ST;
import gregtech.items.behaviors.Behavior_DataStorage;
import gregtech.items.behaviors.Behavior_DataStorage16;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;


public class PTParticleMultiItem extends MultiItemRandom {
    public PTParticleMultiItem() {
        super(MD.GT.mID, "polytekk.multiitem.alpha");
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "PolyTekk", this, (short)1008));
    }
    @Override
    public void addItems() {
        PT_ItemCont.Proton.set(addItem(1, "Proton", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Anti_Proton.set(addItem(2, "Anti Proton", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Electron.set(addItem(3, "Electron", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Positron.set(addItem(4, "Positron (Anti Electron)", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Neutron.set(addItem(5, "Neutron", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Anti_Neutron.set(addItem(6, "Anti-Neutron", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Neutrino.set(addItem(7, "Neutrino", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Anti_Neutrino.set(addItem(8, "Anti Neutrino", "A subatomic particle. Can be produced in particle collider."));
        PT_ItemCont.Higgs_Boson.set(addItem(9, "Higgs-Boson", "A scalar boson of the Standard model. Origin of mass. "));
        PT_ItemCont.Higgs_Boson.set(addItem(10, "Photon", "A gauge boson of the Standard Model. Carrier of the electromagnetic force. "));
        PT_ItemCont.Comb_Rad.set(addItem(50, "Rad Comb", "Better break out the Geiger Counter for this one..."));
        PT_ItemCont.Comb_Actinide.set(addItem(51, "Actinide Comb", "Portable fission fragments in a convenient waxy container!"));
        PT_ItemCont.Comb_Schrabidium.set(addItem(52, "Schrabidium Comb", "A marvel of modern nuclear science and bumble-ology!"));
    }
}
