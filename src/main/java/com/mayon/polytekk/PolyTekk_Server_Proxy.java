package com.mayon.polytekk;

import com.mayon.polytekk.loaders.worldgen.PT_WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import gregapi.api.Abstract_Proxy;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class PolyTekk_Server_Proxy extends Abstract_Proxy implements IWorldGenerator {

    @Override
    public void generate(Random aRandom, int aChunkX, int aChunkZ, World aWorld, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        PT_WorldGenerator.generate(aWorld, aChunkX << 4, aChunkZ << 4);
    }

}
