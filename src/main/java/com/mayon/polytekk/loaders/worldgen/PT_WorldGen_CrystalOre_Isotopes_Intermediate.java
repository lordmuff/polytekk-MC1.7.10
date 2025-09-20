package com.mayon.polytekk.loaders.worldgen;

import com.mayon.polytekk.data.PT_BlockCont;
import gregapi.util.WD;
import gregapi.worldgen.WorldgenObject;
import gregtech.worldgen.NoiseGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static gregapi.data.CS.*;

public class PT_WorldGen_CrystalOre_Isotopes_Intermediate extends WorldgenObject {

    @SafeVarargs
    public PT_WorldGen_CrystalOre_Isotopes_Intermediate(String aName, boolean aDefault, List<WorldgenObject>... aLists) {
        super(aName, aDefault, aLists);
    }

    @Override
    public boolean generate(World aWorld, Chunk aChunk, int aDimType, int aMinX, int aMinZ, int aMaxX, int aMaxZ, Random aRandom, BiomeGenBase[][] aBiomes, Set<String> aBiomeNames) {
        if (aRandom.nextBoolean()) return F;
        int aX = aMinX+aRandom.nextInt(16), aY = WD.waterLevel(aWorld), aZ = aMinZ+aRandom.nextInt(16), aMeta = new NoiseGenerator(aWorld).get(aX/2, 360, aZ/2, PT_BlockCont.CrystalOresPT_Isotopes_Intermediate.maxMeta());

        while (WD.air(aWorld, aX, ++aY, aZ) && aY < aWorld.getHeight());
        Block tBlock = WD.block(aWorld, aX, aY, aZ);
        if (tBlock.getMaterial() != Material.rock) return F;
        if (--aY -10 < WD.waterLevel(aWorld)) return F;

        aWorld.setBlock(aX, aY, aZ, PT_BlockCont.CrystalOresPT_Isotopes_Intermediate, aMeta, 2);
        for (int i = 0; i < 700; ++i) {
            int tX = aX+aRandom.nextInt(8)-aRandom.nextInt(8), tY = aY-aRandom.nextInt(12), tZ = aZ+aRandom.nextInt(8)-aRandom.nextInt(8);
            if (WD.air(aWorld, tX, tY, tZ)) {
                int tCount = 0;
                for (int tSide : ALL_SIDES_VALID) {
                    Block block = aWorld.getBlock(tX+OFFX[tSide], tY+OFFY[tSide], tZ+OFFZ[tSide]);
                    if (block == PT_BlockCont.CrystalOresPT_Isotopes_Intermediate) tCount++;
                }
                if (tCount == 1) aWorld.setBlock(tX, tY, tZ, PT_BlockCont.CrystalOresPT_Isotopes_Intermediate, aMeta, 2);
            }
        }
        return T;
    }

}
