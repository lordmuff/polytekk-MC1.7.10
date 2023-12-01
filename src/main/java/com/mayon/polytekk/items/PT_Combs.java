

package com.mayon.polytekk.items;

import com.mayon.polytekk.data.PT_ItemCont;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.item.CreativeTab;
import gregapi.item.IItemRottable;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PT_Combs extends MultiItemRandomWithCompat implements IItemRottable {
    public PT_Combs(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "GregTech: Nature & Foods", this, (short)12000));
    }

    @Override
    public void addItems() {

        PT_ItemCont.Comb_Rad.set(addItem(1, "Rad Comb", "Wasteland Whisperer's Favorite Treat"));
        PT_ItemCont.Comb_Actinide.set(addItem(2, "Actinide Comb", "It still seems to be fissioning..."));
        PT_ItemCont.Comb_Schrabidium.set(addItem(3, "Schrabidium Comb", "A marvel of modern Bumbleology!"));
        PT_ItemCont.Comb_Xen.set(addItem(4, "Extradimensional Comb", "A Comb Out of Space"));
        PT_ItemCont.Comb_Limpid.set(addItem(5, "Limpid Comb", "xXxBloodyRists666xXx Approved!"));
        PT_ItemCont.Comb_Waste.set(addItem(6, "Wasteland Comb", "The Elephant's Comb"));
        PT_ItemCont.Comb_Fallout.set(addItem(7, "Fallout Comb", "Enewetak Home Recipe"));

    }

    @Override
    public ItemStack getRotten(ItemStack aStack) {
        short aMeta = ST.meta_(aStack);
        if (UT.Code.inside(    0,   999, aMeta)) return (IL.ENVM_Rotten_Food.exists()?IL.ENVM_Rotten_Food:IL.Remains_Plant).get(aStack.stackSize);
        if (UT.Code.inside( 1100,  1999, aMeta)) return ST.make(Items.rotten_flesh, aStack.stackSize, 0);
        if (UT.Code.inside(13000, 13999, aMeta)) return null;
        if (UT.Code.inside(31000, 31999, aMeta)) return aStack;

        switch(aMeta) {
            case 12000: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 12001: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 12002: return ST.make(this, aStack.stackSize, 12003, aStack.getTagCompound());
            case 12004: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 12005: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 12006: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 12007: return ST.make(this, aStack.stackSize, 12002, aStack.getTagCompound());
            case 32700: return (IL.ENVM_Rotten_Food.exists()?IL.ENVM_Rotten_Food:IL.Remains_Plant).get(aStack.stackSize);
            case 32701: return (IL.ENVM_Rotten_Food.exists()?IL.ENVM_Rotten_Food:IL.Remains_Plant).get(aStack.stackSize);
            case 32105: case 32107: return OP.ingot.mat(MT.MeatRotten, aStack.stackSize);
            case 32113: case 32115: return OP.ingot.mat(MT.FishRotten, aStack.stackSize);

            default: return ST.food(aStack) > 0 ? IL.ENVM_Rotten_Food.exists() ? IL.ENVM_Rotten_Food.get(aStack.stackSize) : null : aStack;
        }
    }

    @Override public ItemStack getRotten(ItemStack aStack, World aWorld, int aX, int aY, int aZ) {return getRotten(aStack);}
}