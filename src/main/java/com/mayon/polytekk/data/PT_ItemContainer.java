//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mayon.polytekk.data;

import gregapi.api.Abstract_Mod;
import gregapi.code.IItemContainer;
import gregapi.code.TagData;
import gregapi.data.CS;
import gregapi.item.IItemEnergy;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT.NBT;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum PT_ItemContainer implements IItemContainer {
    Photon,
    Proton,
    Anti_Proton,
    Electron,
    Positron,
    Neutron,
    Anti_Neutron,
    Alpha_Particle,
    Neutrino,
    Anti_Neutrino,
    Higgs_Boson,
    Kerr_Blackhole;

    private ItemStack mStack;
    private boolean mHasNotBeenSet = true;

    private PT_ItemContainer() {
    }// 27

    public IItemContainer set(Item aItem) {
        this.mHasNotBeenSet = false;// 31
        if (aItem == null) {// 32
            return this;// 34
        } else {
            this.mStack = ST.amount(1L, ST.make(aItem, 1L, 0L));// 36
            return this;// 37
        }
    }

    public IItemContainer set(Item aItem, long aMeta) {
        this.mHasNotBeenSet = false;// 41
        if (aItem == null) {// 42
            return this;// 44
        } else {
            this.mStack = ST.amount(1L, ST.make(aItem, 1L, aMeta));// 46
            return this;// 47
        }
    }

    public IItemContainer set(ItemStack aStack) {
        this.mHasNotBeenSet = false;// 52
        if (ST.invalid(aStack)) {// 53
            return this;// 55
        } else {
            this.mStack = ST.amount(1L, aStack);// 57
            return this;// 58
        }
    }

    public IItemContainer set(Item aItem, OreDictItemData aData, Object... aOreDict) {
        this.mHasNotBeenSet = false;// 62
        if (aItem == null) {// 63
            return this;// 65
        } else {
            ItemStack aStack = ST.make(aItem, 1L, 0L);// 67
            this.mStack = ST.amount(1L, aStack);// 68
            if (aData != null && !OM.reg(aData.toString(), ST.make(aItem, 1L, 32767L))) {// 69
                OM.data(ST.make(aItem, 1L, 32767L), aData);
            }

            Object[] var5 = aOreDict;// 70
            int var6 = aOreDict.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Object tOreDict = var5[var7];
                OM.reg(tOreDict, ST.make(aItem, 1L, 32767L));
            }

            return this;// 71
        }
    }

    public IItemContainer set(ItemStack aStack, OreDictItemData aData, Object... aOreDict) {
        this.mHasNotBeenSet = false;// 75
        if (ST.invalid(aStack)) {// 76
            return this;// 78
        } else {
            this.mStack = ST.amount(1L, aStack);// 80
            if (aData != null && !OM.reg(aData.toString(), ST.amount(1L, aStack))) {// 81
                OM.data(ST.amount(1L, aStack), aData);
            }

            Object[] var4 = aOreDict;
            int var5 = aOreDict.length;

            for(int var6 = 0; var6 < var5; ++var6) {// 82
                Object tOreDict = var4[var6];
                OM.reg(tOreDict, ST.amount(1L, aStack));
            }

            return this;// 83
        }
    }

    public Item item() {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 88
        }

        return ST.invalid(this.mStack) ? null : this.mStack.func_77973_b();// 89 90
    }

    public Block block() {
        return ST.block(this.get(0L));// 95
    }

    public boolean exists() {
        return ST.valid(this.mStack);// 100
    }

    public final boolean hasBeenSet() {
        return !this.mHasNotBeenSet;// 105
    }

    public boolean equal(Object aStackOrBlock) {
        boolean var10000;
        label27: {
            if (this.mStack != null) {// 110
                if (aStackOrBlock instanceof Block) {
                    if (aStackOrBlock != CS.NB && ST.block_(this.mStack) == aStackOrBlock) {
                        break label27;
                    }
                } else if (this.equal(aStackOrBlock, false, false)) {
                    break label27;
                }
            }

            var10000 = false;
            return var10000;
        }

        var10000 = true;
        return var10000;
    }

    public boolean equal(Object aStack, boolean aWildcard, boolean aIgnoreNBT) {
        boolean var10000;
        label25: {
            if (this.mStack != null) {
                if (aWildcard) {
                    if (ST.item((ItemStack)aStack) == ST.item_(this.mStack)) {
                        break label25;
                    }
                } else if (ST.equal((ItemStack)aStack, this.mStack, aIgnoreNBT)) {// 115
                    break label25;
                }
            }

            var10000 = false;
            return var10000;
        }

        var10000 = true;
        return var10000;
    }

    public ItemStack get(long aAmount, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 120
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.amount(aAmount, OM.get_(this.mStack));// 121 122
    }

    public ItemStack getWildcard(long aAmount, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 128
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, 32767L, OM.get_(this.mStack));// 129 130
    }

    public ItemStack wild(long aAmount, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 135
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, 32767L, OM.get_(this.mStack));// 136 137
    }

    public ItemStack getUndamaged(long aAmount, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 142
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, 0L, OM.get_(this.mStack));// 143 144
    }

    public ItemStack getAlmostBroken(long aAmount, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 149
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, (long)(this.mStack.func_77958_k() - 1), OM.get_(this.mStack));// 150 151
    }

    public ItemStack getWithName(long aAmount, String aDisplayName, Object... aReplacements) {
        ItemStack rStack = this.get(1L, aReplacements);// 156
        if (ST.invalid(rStack)) {
            return null;// 157
        } else {
            rStack.func_151001_c(aDisplayName);// 158
            return ST.amount(aAmount, rStack);// 159
        }
    }

    public ItemStack getWithNameAndNBT(long aAmount, String aDisplayName, NBTTagCompound aNBT, Object... aReplacements) {
        ItemStack rStack = this.get(1L, aReplacements);// 164
        if (ST.invalid(rStack)) {
            return null;// 165
        } else {
            NBT.set(rStack, aNBT);// 166
            if (aDisplayName != null) {
                rStack.func_151001_c(aDisplayName);// 167
            }

            return ST.amount(aAmount, rStack);// 168
        }
    }

    public ItemStack getWithCharge(long aAmount, long aEnergy, Object... aReplacements) {
        ItemStack rStack = this.get(1L, aReplacements);// 173
        if (ST.invalid(rStack)) {// 174
            return null;
        } else {
            if (rStack.func_77973_b() instanceof IItemEnergy) {
                Iterator var7 = ((IItemEnergy)rStack.func_77973_b()).getEnergyTypes(rStack).iterator();// 175

                while(var7.hasNext()) {
                    TagData tEnergyType = (TagData)var7.next();
                    ((IItemEnergy)rStack.func_77973_b()).setEnergyStored(tEnergyType, rStack, aEnergy);
                }
            }

            return ST.amount(aAmount, rStack);// 176
        }
    }

    public ItemStack getWithMeta(long aAmount, long aMetaValue, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 181
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, aMetaValue, OM.get_(this.mStack));// 182 183
    }

    public ItemStack getWithDamage(long aAmount, long aMetaValue, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 188
        }

        return ST.invalid(this.mStack) ? ST.copyFirst(aReplacements) : ST.copyAmountAndMeta(aAmount, aMetaValue, OM.get_(this.mStack));// 189 190
    }

    public ItemStack getWithNBT(long aAmount, NBTTagCompound aNBT, Object... aReplacements) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 195
        }

        if (ST.invalid(this.mStack)) {
            return ST.copyFirst(aReplacements);// 196
        } else {
            ItemStack rStack = ST.amount(aAmount, OM.get_(this.mStack));// 197
            NBT.set(rStack, aNBT);// 198
            return rStack;// 199
        }
    }

    public IItemContainer registerOre(Object... aOreNames) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 204
        }

        Object[] var2 = aOreNames;
        int var3 = aOreNames.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object tOreName = var2[var4];// 205
            OM.reg(tOreName, this.get(1L));
        }

        return this;// 206
    }

    public IItemContainer registerWildcardAsOre(Object... aOreNames) {
        if (this.mHasNotBeenSet && Abstract_Mod.sFinalized < Abstract_Mod.sModCountUsingGTAPI) {
            CS.ERR.println("The Enum '" + this.name() + "' has not been set to an Item at this time!");// 211
        }

        Object[] var2 = aOreNames;
        int var3 = aOreNames.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object tOreName = var2[var4];// 212
            OM.reg(tOreName, this.wild(1L));
        }

        return this;// 213
    }

    public Item getItem() {
        return this.item();// 216
    }

    public Block getBlock() {
        return this.block();// 217
    }
}
