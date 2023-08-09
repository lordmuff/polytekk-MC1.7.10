//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mayon.polytekk.items;

import com.mayon.polytekk.tileentity.multiblocks.MultiTileEntityParticleCollider;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.TD.Energy;
import gregapi.oredict.OreDictMaterial;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.UT.Code;
import gregapi.util.UT.NBT;
import net.minecraft.tileentity.TileEntity;

public class PTMultiRegistry {
    public static MultiTileEntityMultiBlockPart MULT;

    public PTMultiRegistry() {
    }// 120

    private static void PTMultiblocks(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetal, MultiTileEntityBlock aMetalChips, MultiTileEntityBlock aMetalWires, MultiTileEntityBlock aMachine, MultiTileEntityBlock aWooden, MultiTileEntityBlock aBush, MultiTileEntityBlock aStone, MultiTileEntityBlock aWool, MultiTileEntityBlock aTNT, MultiTileEntityBlock aHive, MultiTileEntityBlock aUtilMetal, MultiTileEntityBlock aUtilStone, MultiTileEntityBlock aUtilWood, MultiTileEntityBlock aUtilWool, OreDictMaterial aMat, Class<? extends TileEntity> aClass) {
        aMat = MT.Osmiridium;// 123
        aRegistry.add("Particle Collider", "Multiblock Machines", 17200, 17101, MultiTileEntityParticleCollider.class, aMat.mToolQuality, 16, aMachine, NBT.make("gt.material", aMat, new Object[]{"gt.hardness", 12.5F, "gt.resistance", 12.5F, "gt.color", Code.getRGBInt(aMat.fRGBaSolid), "gt.texture", "particlecollider", "gt.input", 8192, "gt.input.min", 1, "gt.input.max", 524288, "gt.energy.accepted", Energy.EU, "gt.recipemap", "gt.recipe.particlecollider", "gt.energy.accepted.2", Energy.EU, "gt.special.start.energy", true}), new Object[]{"FFF", "FMF", "FFF", 'M', aRegistry.getItem(18014), 'F', IL.FIELD_GENERATORS[5]});
    }// 124
}
