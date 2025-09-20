package com.mayon.polytekk.blocks;

import com.mayon.polytekk.loaders.ores.PT_Loader_Materials;
import gregapi.block.BlockBaseMeta;
import gregapi.data.LH;
import gregapi.data.MD;
import gregapi.data.OP;
import gregapi.old.Textures;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.OM;
import gregapi.util.ST;
import mods.railcraft.common.carts.EntityTunnelBore;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

import static gregapi.data.CS.*;

public class PT_BlockCrystalOres_Schrabidium extends BlockBaseMeta {

    public static OreDictMaterial[] ORE_MATERIALS = {PT_Loader_Materials.Schrabidium, PT_Loader_Materials.Solinium};

    public PT_BlockCrystalOres_Schrabidium(String aUnlocalised) {
        super(null, aUnlocalised, Material.glass, soundTypeGlass, ORE_MATERIALS.length, Textures.BlockIcons.CRYSTAL_ORES);
        LH.add(getUnlocalizedName()+ ".0", "Crystalline Schrabidium");
        LH.add(getUnlocalizedName()+ ".1", "Crystalline Solinium");

        for (int i = 0; i < maxMeta(); i++) {
            OM.reg(ST.make(this, 1, i), OP.oreDense.dat(ORE_MATERIALS[i]));
            if (COMPAT_IC2 != null) COMPAT_IC2.valuable(this, i, 2);
        }

        if (MD.RC.mLoaded) try {
            EntityTunnelBore.addMineableBlock(this);} catch(Throwable e) {e.printStackTrace(ERR);}
        if (COMPAT_FR  != null) COMPAT_FR.addToBackpacks("miner", ST.make(this, 1, W));
    }

    @Override
    public ArrayList<ItemStack> getDrops(World aWorld, int aX, int aY, int aZ, int aMeta, int aFortune) {
        return ST.arraylist(OP.oreRaw.mat(ORE_MATERIALS[aMeta], aFortune>0?2+RNGSUS.nextInt(aFortune*2+2):2));
    }

    @Override
    public int getExpDrop(IBlockAccess aWorld, int aMeta, int aFortune) {
        return 3+RNGSUS.nextInt(4);
    }

    @Override public boolean doesPistonPush(byte aMeta) {return T;}
    @Override public boolean canCreatureSpawn(byte aMeta) {return T;}
    @Override public boolean isSealable(byte aMeta, byte aSide) {return F;}
    @Override public String getHarvestTool(int aMeta) {return TOOL_pickaxe;}
    @Override public int getHarvestLevel(int aMeta) {return 0;}
    @Override public float getBlockHardness(World aWorld, int aX, int aY, int aZ) {return Blocks.glowstone.getBlockHardness(aWorld, aX, aY, aZ);}
    @Override public float getExplosionResistance(byte aMeta) {return Blocks.glowstone.getExplosionResistance(null);}

}
