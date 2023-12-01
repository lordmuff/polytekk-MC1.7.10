package com.mayon.polytekk.items;

import Reika.ChromatiCraft.ModInterface.ItemColoredModInteract;
import Reika.ChromatiCraft.Registry.ChromaBlocks;
import Reika.ChromatiCraft.Registry.CrystalElement;
import com.mayon.polytekk.data.PT_ItemCont;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.block.metatype.BlockStones;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.damage.DamageSources;
import gregapi.data.*;
import gregapi.item.CreativeTab;
import gregapi.item.bumble.IItemBumbleBee;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import gregapi.old.Textures;
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import gregapi.util.WD;
import gregtech.blocks.BlockDiggable;
import gregtech.tileentity.plants.MultiTileEntityResinHoleRubber;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static gregapi.data.CS.*;


public class PT_Bumbles extends MultiItemRandomWithCompat implements IItemBumbleBee {
    public PT_Bumbles(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "GregTech: Bumblebees", this, (short) 2));
        if (!SHOW_BUMBLEBEES) ST.hide(this);
    }

    @Override
    public void addItems() {

        make(0, "Limpid Bumblebee", "Hi my name is Ebeeny Darkness Dementia Raven Way");
        make(10, "Crystalline Bumblebee", "");
        make(20, "Walter Bumbwell White", "My name is Walter Bumbwell White, and this is my confession.");
        make(30, "Clairvoyant Bumblebee", "Sees all that could Bee, has Been, and could ever Bee!");

        make(100, "Xen Bumblebee", "Has prepared for Unforeseen Consequences");
        make(110, "Proximal Bumblebee", "No Spoilers!");
        make(120, "Dr. Gordon Beeman", "Is a Highly Trained Professional");
        make(130, "Interstellar Bumblebee", "Proxima Centuari or Bust!");

        make(200, "Kuro Bumblebee", "");
        make(210, "Bumblewarlock", "Has sold it's Soul for Power!");
        make(220, "Bumblepsyker", "Suffers not the Witch!");
        make(230, "Arch-Magister Bumblebee", "Master of the Arcane!");

        make(300, "Karmir Bumblebee", "");
        make(310, "Vigilant Bumblebee", "Forever watching, forever seeing...");
        make(320, "Paladin Bumble", "Sworn to an Oath");
        make(330, "Shield of Bumblekind", "Protector of the Innocent");

        make(400, "Kijani Bumblebee", "");
        make(410, "Bumbledruid", "Women DO love a Winner...");
        make(420, "Kjiani Bumblebee (T3)", "");
        make(430, "Bumble of The Sacred Glade", "Hears the Call of Nature");

        make(500, "Ruskea Bumblebee", "");
        make(510, "Bumbleminer", "Diggy Diggy Hole!");
        make(520, "Bumblebeard", "That's goin' in the Book!");
        make(530, "Urist McBumble", "Has lost their Socks!");

        make(600, "Nila Bumblebee", "");
        make(610, "Nila Bumblebee (T2)", "");
        make(620, "Nila Bumblebee (T3)", "");
        make(630, "Nila Bumblebee (T4)", "");

        make(700, "Zambarau Bumblebee", "");
        make(710, "Zambarau Bumblebee (T2)", "");
        make(720, "Zambarau Bumblebee (T3)", "");
        make(730, "Zambarau Bumblebee (T4)", "");

        make(800, "Vadali Bumblebee", "");
        make(810, "Vadali Bumblebee (T2)", "");
        make(820, "Vadali Bumblebee (T3)", "");
        make(830, "Vadali Bumblebee (T4)", "");

        make(900, "Argia Bumblebee", "");
        make(910, "Argia Bumblebee (T2)", "");
        make(920, "Argia Bumblebee (T3)", "");
        make(930, "Argia Bumblebee (T4)", "");

        make(1000, "Ykri Bumblebee", "");
        make(1010, "Ykri Bumblebee (T2)", "");
        make(1020, "Ykri Bumblebee (T3)", "");
        make(1030, "Ykri Bumblebee (T4)", "");

        make(1100, "Ruzova Bumblebee", "");
        make(1110, "Ruzova Bumblebee (T2)", "");
        make(1120, "Ruzova Bumblebee (T3)", "");
        make(1130, "Ruzova Bumblebee (T4)", "");

        make(1200, "Asveste Bumblebee", "");
        make(1210, "Asveste Bumblebee (T2)", "");
        make(1220, "Asveste Bumblebee (T3)", "");
        make(1230, "Asveste Bumblebee (T4)", "");

        make(1300, "Kitrino Bumblebee", "");
        make(1310, "Kitrino Bumblebee (T2)", "");
        make(1320, "Kitrino Bumblebee (T3)", "");
        make(1330, "Kitrino Bumblebee (T4)", "");

        make(1400, "Galazio Bumblebee", "");
        make(1410, "Galazio Bumblebee (T2)", "");
        make(1420, "Galazio Bumblebee (T3)", "");
        make(1430, "Galazio Bumblebee (T4)", "");

        make(1500, "Kurauri Bumblebee", "");
        make(1510, "Kurauri Bumblebee (T2)", "");
        make(1520, "Kurauri Bumblebee (T3)", "");
        make(1530, "Kurauri Bumblebee (T4)", "");

        make(1600, "Portokali Bumblebee", "");
        make(1610, "Portokali Bumblebee (T2)", "");
        make(1620, "Portokali Bumblebee (T3)", "");
        make(1630, "Portokali Bumblebee (T4)", "");

        make(1700, "Tahara Bumblebee", "");
        make(1710, "Tahara Bumblebee (T2)", "");
        make(1720, "Tahara Bumblebee (T3)", "");
        make(1730, "Tahara Bumblebee (T4)", "");


        // Tera + Aero = Rad
        make(1800, "Radbumble", "Wasteland Wildlife");
        make(1810, "Bumbleclaw", "Apex Predator");
        make(1820, "Scorched Bumble", "From the bad one!");
        make(1830, "Bumblebeast", "Terror of the Appalachians!");

        // Rad + Pyro = Actinide
        make(1900, "Actinide Bumblebee", "");
        make(1910, "Critical Bumblebee", "Fissioning at a steady rate...");
        make(1920, "Beemon Core", "Supercritical!");
        make(1930, "Robert J. Bumbleheimer", "I am become Death, the Destroyer of Hives");

        // Rad + Actinide = Schrabidium
        make(2000, "Schrabidium Bumblebee", "");
        make(2010, "Bumble Schrabidate", "");
        make(2020, "Bumbolinium", "Like Solinium! Get it?");
        make(2030, "Gelid Euphemium Bumblide", "Formerly known as the Cheater Virus");

        // Actinide + Satanic = Waste
        make(2100, "Wasted Bumblebee", "Yoooo, dude! I'm Schwasted!");
        make(2110, "Chernobumbyl", "Get out of here, Stalker!");
        make(2120, "Nuclear Deterrent Spike Bumble", "Not the same thing as Nuclear Deterrence!");
        make(2130, "Dangerous and Repulsive Bumblebee", "No highly esteemed Deed is commemorated here...");

        // Waste + Military = Fallout
        make(2200, "Vault Bumbler", "A better future... in some hole in the ground. What did you expect?");
        make(2210, "Bumblehood of Steel", "Ad Victoriam!");
        make(2220, "Bumbleclave Remnant", "Thank you, God Bless you, and God Bless the United States of America");
        make(2230, "President John Henry Bumble", "100% Human");
    }

    public void make(int aSpeciesID, String aName, String aTooltip) {
        for (int i : new int[]{0, 1, 4}) {
            for (String tFluid : FluidsGT.HONEY)
                if (FL.exists(tFluid))
                    RM.Bumblelyzer.addFakeRecipe(F, ST.array(ST.make(this, 1, aSpeciesID + i), OP.plateTiny.mat(MT.Paper, 1)), ST.array(ST.make(this, 1, aSpeciesID + i + 5)), null, null, FL.array(FL.make(tFluid, 10)), null, 64, 16, 0);
            RM.Bumblelyzer.addFakeRecipe(F, ST.array(ST.make(this, 1, aSpeciesID + i), OP.plateTiny.mat(MT.Paper, 1)), ST.array(ST.make(this, 1, aSpeciesID + i + 5)), null, null, FL.array(FL.Honeydew.make(10)), null, 64, 16, 0);
            RM.Bumblelyzer.addFakeRecipe(F, ST.array(ST.make(this, 1, aSpeciesID + i + 5, "Was already scanned, auto-skipping")), ST.array(ST.make(this, 1, aSpeciesID + i + 5, "Just passed to the Output")), null, null, null, null, 1, 16, 0);
            RM.Bumblelyzer.addFakeRecipe(F, ST.array(ST.make(this, 1, aSpeciesID + i + 5, "Was already scanned, auto-skipping")), ST.array(ST.make(this, 1, aSpeciesID + i + 5, "Just passed to the Output")), null, null, null, null, 1, 16, 0);
        }

        addItem(aSpeciesID + 0, aName + " Drone", aTooltip, "gt:bumbledrone", TC.stack(TC.BESTIA, 1));
        addItem(aSpeciesID + 1, aName + " Princess", aTooltip, "gt:bumbleprincess", TC.stack(TC.BESTIA, 2));
        addItem(aSpeciesID + 2, aName + " Queen", aTooltip, "gt:bumblequeen", TC.stack(TC.BESTIA, 2), TD.Creative.HIDDEN);
        addItem(aSpeciesID + 4, aName + " (Dead)", aTooltip, "gt:bumbledead", TC.stack(TC.MORTUUS, 1), TD.Creative.HIDDEN);
        addItem(aSpeciesID + 5, aName + " Drone (Scanned)", aTooltip, "gt:bumbledrone", TC.stack(TC.BESTIA, 1), TC.stack(TC.COGNITIO, 1), new OreDictItemData(MT.Paper, U9));
        addItem(aSpeciesID + 6, aName + " Princess (Scanned)", aTooltip, "gt:bumbleprincess", TC.stack(TC.BESTIA, 2), TC.stack(TC.COGNITIO, 1), new OreDictItemData(MT.Paper, U9));
        addItem(aSpeciesID + 7, aName + " Queen (Scanned)", aTooltip, "gt:bumblequeen", TC.stack(TC.BESTIA, 2), TC.stack(TC.COGNITIO, 1), new OreDictItemData(MT.Paper, U9), TD.Creative.HIDDEN);
        addItem(aSpeciesID + 9, aName + " (Dead & Scanned)", aTooltip, "gt:bumbledead", TC.stack(TC.MORTUUS, 1), TC.stack(TC.COGNITIO, 1), new OreDictItemData(MT.Paper, U9), TD.Creative.HIDDEN);

        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 0), ST.make(this, 1, aSpeciesID + 2));
        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 1), ST.make(this, 1, aSpeciesID + 2));
        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 4), ST.make(this, 1, aSpeciesID + 2));

        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 5), ST.make(this, 1, aSpeciesID + 7));
        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 6), ST.make(this, 1, aSpeciesID + 7));
        CS.ItemsGT.addNEIRedirect(ST.make(this, 1, aSpeciesID + 9), ST.make(this, 1, aSpeciesID + 7));

        ItemStack[] tOutputs = new ItemStack[bumbleProductCount(NI, (short) (aSpeciesID + 2))];
        long[] tChances = new long[tOutputs.length];
        for (int i = 0; i < tOutputs.length; i++) {
            tOutputs[i] = bumbleProductStack(NI, (short) (aSpeciesID + 2), 1, i);
            tChances[i] = bumbleProductChance(NI, (short) (aSpeciesID + 2), i);
        }

        RM.BumbleQueens.addFakeRecipe(F, ST.array(ST.make(this, 1, aSpeciesID + 2), ST.make(this, 1, aSpeciesID + 7)), tOutputs, null, tChances, null, null, 0, 0, 0);
    }
    @Override
    public ItemStack bumbleProductStack(ItemStack aBumbleBee, short aMetaData, long aStacksize, int aProductIndex) {
        switch (aMetaData / 100) {
            case 0:
                return PT_ItemCont.Comb_Limpid.get(aStacksize);
            case 1:
                return PT_ItemCont.Comb_Xen.get(aStacksize);
            case 2:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.BLACK);
            case 3:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.RED);
            case 4:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.GREEN);
            case 5:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.BROWN);
            case 6:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.BLUE);
            case 7:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.PURPLE);
            case 8:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.CYAN);
            case 9:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.LIGHTGRAY);
            case 10:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.GRAY);
            case 11:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.PINK);
            case 12:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.LIME);
            case 13:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.YELLOW);
            case 14:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.LIGHTBLUE);
            case 15:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.MAGENTA);
            case 16:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.ORANGE);
            case 17:
                return ItemColoredModInteract.ColoredModItems.COMB.getItem(CrystalElement.WHITE);
            case 18:
                return PT_ItemCont.Comb_Rad.get(aStacksize);
            case 19:
                return PT_ItemCont.Comb_Actinide.get(aStacksize);
            case 20:
                return PT_ItemCont.Comb_Schrabidium.get(aStacksize);
            case 21:
                return PT_ItemCont.Comb_Waste.get(aStacksize);
            case 22:
                return PT_ItemCont.Comb_Fallout.get(aStacksize);
            default:
                return IL.Comb_Honey.get(aStacksize);
        }
    }

    @Override
    public ChunkCoordinates bumbleCanProduce(World aWorld, int aX, int aY, int aZ, ItemStack aBumbleBee, short aMetaData, int aDistance) {
        boolean temp = T;


        aDistance = Math.abs(aDistance);
        int[] tOrderX = RNGSUS.nextBoolean() ? aDistance < SCANS_POS.length ? SCANS_POS[aDistance] : SCANS_POS[SCANS_POS.length - 1] : aDistance < SCANS_NEG.length ? SCANS_NEG[aDistance] : SCANS_NEG[SCANS_NEG.length - 1];
        int[] tOrderY = RNGSUS.nextBoolean() ? aDistance < SCANS_POS.length ? SCANS_POS[aDistance] : SCANS_POS[SCANS_POS.length - 1] : aDistance < SCANS_NEG.length ? SCANS_NEG[aDistance] : SCANS_NEG[SCANS_NEG.length - 1];
        int[] tOrderZ = RNGSUS.nextBoolean() ? aDistance < SCANS_POS.length ? SCANS_POS[aDistance] : SCANS_POS[SCANS_POS.length - 1] : aDistance < SCANS_NEG.length ? SCANS_NEG[aDistance] : SCANS_NEG[SCANS_NEG.length - 1];
        switch (aMetaData / 100) {
            case 0:
                Block tCaveCrystal = ST.block(ChromaBlocks.CRYSTAL.getStackOf());
                Block tLiquidChroma = ST.block(ChromaBlocks.CHROMA.getStackOf());
                Block tPotionCrystal = ST.block(ChromaBlocks.SUPER.getStackOf());
                Block tCrystalPylon = ST.block(ChromaBlocks.PYLON.getStackOf());
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tCaveCrystal) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tLiquidChroma) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tPotionCrystal) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tCrystalPylon) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            return null;
                        }
            case   1:
                Block tEnderPearlDustBlock = ST.block(OM.get(OP.blockDust, MT.EnderPearl, 1));
                Block tEnderEyeDustBlock = ST.block(OM.get(OP.blockDust, MT.EnderEye, 1));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tEnderPearlDustBlock) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tEnderEyeDustBlock) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            return null;
                        }
                return null;
            case 2:
                Block tColoredLeaf0 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(0));
                Block tColoredSapling0 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(0));
                Block tColoredFlower0 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(0));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf0) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling0) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower0) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 3:
                Block tColoredLeaf1 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(1));
                Block tColoredSapling1 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(1));
                Block tColoredFlower1 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(1));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf1) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling1) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower1)      return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 4:
                Block tColoredLeaf2 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(2));
                Block tColoredSapling2 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(2));
                Block tColoredFlower2 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(2));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf2     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling2           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower2) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 5:
                Block tColoredLeaf3 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(3));
                Block tColoredSapling3 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(3));
                Block tColoredFlower3 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(3));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf3     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling3           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower3) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 6:
                Block tColoredLeaf4 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(4));
                Block tColoredSapling4 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(4));
                Block tColoredFlower4 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(4));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf4     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling4           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower4) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 7:
                Block tColoredLeaf5 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(5));
                Block tColoredSapling5 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(5));
                Block tColoredFlower5 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(5));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf5     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling5           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower5) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 8:
                Block tColoredLeaf6 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(6));
                Block tColoredSapling6 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(6));
                Block tColoredFlower6 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(6));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf6     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling6           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower6) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 9:
                Block tColoredLeaf7 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(7));
                Block tColoredSapling7 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(7));
                Block tColoredFlower7 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(7));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf7     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling7           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower7) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 10:
                Block tColoredLeaf8 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(8));
                Block tColoredSapling8 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(8));
                Block tColoredFlower8 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(8));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf8     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling8           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower8) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 11:
                Block tColoredLeaf9 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(9));
                Block tColoredSapling9 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(9));
                Block tColoredFlower9 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(9));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf9     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling9           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower9) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 12:
                Block tColoredLeaf10 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(10));
                Block tColoredSapling10 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(10));
                Block tColoredFlower10 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(10));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf10     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling10           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower10) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 13:
                Block tColoredLeaf11 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(11));
                Block tColoredSapling11 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(11));
                Block tColoredFlower11 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(11));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf11     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling11           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower11) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 14:
                Block tColoredLeaf12 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(12));
                Block tColoredSapling12 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(12));
                Block tColoredFlower12 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(12));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf12     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling12           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower12) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 15:
                Block tColoredLeaf13 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(13));
                Block tColoredSapling13 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(13));
                Block tColoredFlower13 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(13));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf13     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling13           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower13) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 16:
                Block tColoredLeaf14 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(14));
                Block tColoredSapling14 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(14));
                Block tColoredFlower14 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(14));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf14     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling14           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower14) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 17:
                Block tColoredLeaf15 = ST.block(ChromaBlocks.DYELEAF.getStackOfMetadata(15));
                Block tColoredSapling15 = ST.block(ChromaBlocks.DYESAPLING.getStackOfMetadata(15));
                Block tColoredFlower15 = ST.block(ChromaBlocks.DYEFLOWER.getStackOfMetadata(15));
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tColoredLeaf15     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredSapling15           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tColoredFlower15) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 18:
                Block tUraniumFuel = ST.block(MD.HBM, "block_uranium", null);
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tUraniumFuel) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 19:
                Block tPlutoniumFuel = ST.block(MD.HBM, "block_plutonium_fuel", null);
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tPlutoniumFuel) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 20:
                Block tSchrabBlock = ST.block(MD.HBM, "block_schrabidium", null);
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tSchrabBlock) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            case 21:
                Block tNuclearWastePaintedBlock = ST.block(MD.HBM, "block_waste_painted", null);
                Block tNuclearWasteVitrifiedBlock = ST.block(MD.HBM, "block_waste_vitrified", null);
                Block tNuclearWasteBlock = ST.block(MD.HBM, "block_waste", null);
                for (int j : tOrderY)
                    for (int i : tOrderX)
                        for (int k : tOrderZ) {
                            Block tBlock = WD.block(aWorld, aX + i, aY + j, aZ + k, F);
                            if (tBlock == tNuclearWastePaintedBlock     ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tNuclearWasteVitrifiedBlock           ) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                            if (tBlock == tNuclearWasteBlock) return new ChunkCoordinates(aX + i, aY + j, aZ + k);
                            return null;
                        }
            default:
                if (RNGSUS.nextBoolean()) {
                    for (int j : tOrderY) for (int i : tOrderX) for (int k : tOrderZ) if (checkFlowers(aWorld, aX+i, aY+j, aZ+k)) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                } else {
                    for (int j : tOrderY) for (int k : tOrderZ) for (int i : tOrderX) if (checkFlowers(aWorld, aX+i, aY+j, aZ+k)) return new ChunkCoordinates(aX+i, aY+j, aZ+k);
                }
                return null;
        }

    }



    public String getFlowerTooltip(short aMetaData) {
        switch (aMetaData / 100) {
            case 0:
                return "Kuro Plant Life (Flowers, Saplings, Leaves)";
            case 1:
                return "Should be the same as End Bees! (Chorus Flower or Dragon Egg if Et Futurum is installed, otherwise End Biome, Ender Portal, or Dragon Egg)";
            case 2:
                return "Kuro Plant Life (Flowers, Saplings, Leaves)";
            case 3:
                return "Karmir Plant Life (Flowers, Saplings, Leaves)";
            case 4:
                return "Kijani Plant Life (Flowers, Saplings, Leaves)";
            case 5:
                return "Ruskea Plant Life (Flowers, Saplings, Leaves)";
            case 6:
                return "Nila Plant Life (Flowers, Saplings, Leaves)";
            case 7:
                return "Zambarau Plant Life (Flowers, Saplings, Leaves)";
            case 8:
                return "Vadali Plant Life (Flowers, Saplings, Leaves)";
            case 9:
                return "Argia Plant Life (Flowers, Saplings, Leaves)";
            case 10:
                return "Ykri Plant Life (Flowers, Saplings, Leaves)";
            case 11:
                return "Ruzova Plant Life (Flowers, Saplings, Leaves)";
            case 12:
                return "Asveste Plant Life (Flowers, Saplings, Leaves)";
            case 13:
                return "Kitrino Plant Life (Flowers, Saplings, Leaves)";
            case 14:
                return "Galazio Plant Life (Flowers, Saplings, Leaves)";
            case 15:
                return "Kurauri Plant Life (Flowers, Saplings, Leaves)";
            case 16:
                return "Portokali Plant Life (Flowers, Saplings, Leaves)";
            case 17:
                return "Tahara Plant Life (Flowers, Saplings, Leaves)";
            case 18:
                return "Uraninite / Natural Uranium Blocks";
            case 19:
                return "Plutonium Fuel Blocks";
            case 20:
                return "Schrabidium Blocks";
            case 21:
                return "Nuclear Waste Blocks (Vitrified and Painted variants work too!)";
            default:
                return "Flowers (even potted ones work)";
        }
    }

    @Override
    public ItemStack bumbleCombine(ItemStack aBumbleBeeA, short aMetaDataA, ItemStack aBumbleBeeB, short aMetaDataB, byte aBumbleType, Random aRandom) {
        // Special Case to give even chances to Addon Bumbles.
        if (aBumbleBeeB.getItem() != ItemsGT.BUMBLEBEES)
            return ((IItemBumbleBee) aBumbleBeeB.getItem()).bumbleCombine(aBumbleBeeA, aMetaDataA, aBumbleBeeB, aMetaDataB, aBumbleType, aRandom);
        if (aBumbleBeeA.getItem() != ItemsGT.BUMBLEBEES)
            return ((IItemBumbleBee) aBumbleBeeA.getItem()).bumbleCombine(aBumbleBeeA, aMetaDataA, aBumbleBeeB, aMetaDataB, aBumbleType, aRandom);
        // The Normal Case if the other Bumble does not match. Should not be possible to call this one in my own class anymore though, because above.
        if (aBumbleBeeB.getItem() != this)
            return ST.copyAmountAndMeta(1, (aMetaDataA / 10) * 10 + aBumbleType, aBumbleBeeA);
        if (aBumbleBeeA.getItem() != this)
            return ST.copyAmountAndMeta(1, (aMetaDataB / 10) * 10 + aBumbleType, aBumbleBeeB);
        // And all the GT6 Bumblebee breeding cases.
        switch (aMetaDataA / 10) {
            //Aero + Pyro = Rad
            case 2033:
                switch (aMetaDataB / 10) {
                    case 2023:
                        return ST.make(this, 1, 1800 + aBumbleType);
                }
                break;
                //Aero + Pyro = Rad
            // Aero + Rad = Xen
            case   2023:
                switch(aMetaDataB / 10) {
                    case   2033: return ST.make(this, 1, 1800+aBumbleType);
                    case   183: return ST.make(this, 1, 100+aBumbleType);
                }
                break;
                //Rad + Pyro = Actinide
            // Rad + Actinide = Schrabidium
            // Rad + Satanic = Waste
            case   183:
                switch(aMetaDataB / 10) {
                    case   2003: return ST.make(this, 1, 1900+aBumbleType);
                    case   193: return ST.make(this, 1, 2000+aBumbleType);
                    case   1033: return ST.make(this, 1, 2100+aBumbleType);

                }
                // Rad + Satanic = Waste
            case   1033:
                switch(aMetaDataB / 10) {
                   case   183: return ST.make(this, 1, 2100+aBumbleType);
                }
                break;
                //Actinide + Rad = Schrabidium
            case   193:
                switch(aMetaDataB / 10) {
                    case   183: return ST.make(this, 1, 2000+aBumbleType);
                }
                break;
                //Rad + Pyro = Actinide
            // Pyro + Limpid = Kitrino
            case   2003:
                switch(aMetaDataB / 10) {
                    case   193: return ST.make(this, 1, 1900+aBumbleType);
                    case   0: return ST.make(this, 1, 1300+aBumbleType);

                }
                break;
                //Rock + End = Limpid
            case   53:
                switch(aMetaDataB / 10) {
                    case   43: return ST.make(this, 1, 0+aBumbleType);
                }
                break;
            //Rock + End = Limpid
            case   43:
                switch(aMetaDataB / 10) {
                    case   53: return ST.make(this, 1, 0+aBumbleType);
                }
                break;
            //Limpid + Xen = Tahara
            // Limpid + Wizard = Kuro
            //Royal + Limpid = Karmir
            case   3:
                switch(aMetaDataB / 10) {
                    case   1: return ST.make(this, 1, 1700+aBumbleType);
                    case   23: return ST.make(this, 1, 200+aBumbleType);
                    case   1023: return ST.make(this, 1, 300+aBumbleType);

                }
                break;
            //Limpid + Xen = Tahara
            case   1:
                switch(aMetaDataB / 10) {
                    case   3: return ST.make(this, 1, 1700+aBumbleType);
                }
                break;
            //Limpid + Wizard = Kuro
            // Amnesic + Wizard = Nila
            case   23:
                switch(aMetaDataB / 10) {
                    case   3: return ST.make(this, 1, 200+aBumbleType);
                    case   1043: return ST.make(this, 1, 600+aBumbleType);

                }
                break;
            //Royal + Limpid = Karmir
            case   1023:
                switch(aMetaDataB / 10) {
                    case   3: return ST.make(this, 1, 300+aBumbleType);
                }
                break;
                //Amnesic + Wizard = Nila
            case   1043:
                switch(aMetaDataB / 10) {
                    case   23: return ST.make(this, 1, 600+aBumbleType);
                }
                break;
                //Jungle + Soldier = Kijani
            // Jungle + Rock = Ruskea
            case   63:
                switch(aMetaDataB / 10) {
                    case   1053: return ST.make(this, 1, 400+aBumbleType);
                    case   53: return ST.make(this, 1, 500+aBumbleType);
                }
                break;
                //Karmir + Kitrino = Portokali
            case   130:
                switch(aMetaDataB / 10) {
                    case   30: return ST.make(this, 1, 1600+aBumbleType);

                }
                break;
            //Karmir + Kitrino = Portokali
            // Karmir + Tahara = Ruzova
            // Karmir + Nila = Zambarau
            case   30:
                switch(aMetaDataB / 10) {
                    case   130: return ST.make(this, 1, 1600+aBumbleType);
                    case   170: return ST.make(this, 1, 1100+aBumbleType);
                    case   60: return ST.make(this, 1, 700+aBumbleType);

                }
                break;
            //Tahara + Kijani = Asveste
            // Tahara + Kuro = Ykri
            //Tahara + Ykri = Argia
            //Tahara + Nila = Galazio
            case   170:
                switch(aMetaDataB / 10) {
                    case   40: return ST.make(this, 1, 1200+aBumbleType);
                    case   20: return ST.make(this, 1, 1000+aBumbleType);
                    case   100: return ST.make(this, 1, 900+aBumbleType);
                    case   60: return ST.make(this, 1, 1400+aBumbleType);

                }
                break;
                //Kijani + Nila = Vadali
            //Tahara + Nila = Galazio
            case   60:
                switch(aMetaDataB / 10) {
                    case   40: return ST.make(this, 1, 800+aBumbleType);
                    case   170: return ST.make(this, 1, 1400+aBumbleType);

                }
                break;
                //Ruzova + Zambarau = Kurauri
            case   113:
                switch(aMetaDataB / 10) {
                    case   73: return ST.make(this, 1, 1500+aBumbleType);

                }
                break;
        }
        return ST.make(this, 1, (aMetaDataA / 10) * 10 + aBumbleType);
    }

    @Override
    public boolean bumbleAttack(ItemStack aBumbleBee, short aMetaData, EntityLivingBase aAttacked) {
        if (UT.Entities.isWearingFullInsectHazmat(aAttacked)) return F;
        /*boolean
                tSkeleton = (aAttacked instanceof EntitySkeleton || (aAttacked instanceof EntityHorse && ((EntityHorse) aAttacked).getHorseType() == 4)), tSnowGolem = (aAttacked.getClass() == EntitySnowman.class), tIronGolem = (aAttacked instanceof EntityIronGolem), tPlayer = (aAttacked instanceof EntityPlayer);
        switch (aMetaData / 100) {
            default:
                return !tSkeleton && !tSnowGolem && !tIronGolem && aAttacked.attackEntityFrom(DamageSources.getBumbleDamage(), (1 + ((aMetaData / 10) % 10)));
            case 9:
                return !tSkeleton && !tSnowGolem && !tIronGolem && aAttacked.attackEntityFrom(DamageSources.getBumbleDamage(), (1 + ((aMetaData / 10) % 10)) * 2);
            case 6:
                return !tSkeleton && !tSnowGolem && !tIronGolem && aAttacked.attackEntityFrom(DamageSources.getBumbleDamage(), (1 + ((aMetaData / 10) % 10)) * 4);
            case 8:
                return F;
            case 3:
                if (!tSkeleton && !tIronGolem && aAttacked.attackEntityFrom(DamageSources.getBumbleDamage().setFireDamage(), (1 + ((aMetaData / 10) % 10)) * 2)) {
                    aAttacked.setFire((1 + ((aMetaData / 10) % 10)) * 10);
                    return T;
                }
                return F;
            case 105:
            case 200:
            case 201:
            case 202:
            case 203:
                return !tPlayer && aAttacked.attackEntityFrom(DamageSources.getBumbleDamage(), (1 + ((aMetaData / 10) % 10)) * 10);

        }*/
        return F;
    }

    @Override
    public int bumbleMutateChance(ItemStack aBumbleBee, short aMetaData) {
        switch ((aMetaData / 10) % 10) {
            case 0:
                return 500;
            case 1:
                return 500;
            case 2:
                return 250;
            case 3:
                return 25;
            default:
                return 0;
        }
    }

    @Override
    public ItemStack bumbleMutate(ItemStack aBumbleBee, short aMetaData, Random aRandom) {
        switch ((aMetaData / 10) % 10) {
            case 0:
                return ST.copyMeta(aMetaData + 10, aBumbleBee);
            case 1:
                return ST.copyMeta(aMetaData + (aRandom.nextBoolean() ? +10 : -10), aBumbleBee);
            case 2:
                return ST.copyMeta(aMetaData + (aRandom.nextBoolean() ? +10 : -10), aBumbleBee);
            case 3:
                return ST.copyMeta(aMetaData - 10, aBumbleBee);
            default:
                return ST.copy(aBumbleBee);
        }
    }

    @Override
    public int bumbleProductChance(ItemStack aBumbleBee, short aMetaData, int aProductIndex) {
        switch ((aMetaData / 10) % 10) {
            case 0:
                return 2500;
            case 1:
                return 5000;
            case 2:
                return 7500;
            case 3:
                return 10000;
            default:
                return 10000;
        }
    }

    @Override
    public int bumbleProductCount(ItemStack aBumbleBee, short aMetaData) {
        return 1;
    }

    @Override
    public ChunkCoordinates bumbleCanProduct(World aWorld, int aX, int aY, int aZ, ItemStack aBumbleBee, short aMetaData, int aProductIndex) {
        return new ChunkCoordinates(aX, aY, aZ);
    }

    @Override
    public void addAdditionalToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        short aMeta = ST.meta_(aStack);
        String tTooltip = getFlowerTooltip(aMeta);
        if (UT.Code.stringValid(tTooltip)) aList.add(LH.Chat.CYAN + "Requirement:" + LH.Chat._WHITE + tTooltip);
        NBTTagCompound aBumbleTag = null;
        if (aStack.hasTagCompound()) aBumbleTag = aStack.getTagCompound().getCompoundTag("gt.bumble");
        if (aBumbleTag == null || aBumbleTag.hasNoTags()) {
            aList.add(LH.Chat.BLINKING_RED + "No Genetic Data to display");
            aList.add(LH.Chat.CYAN + "Generates random 'Outsider-Plains-Biome' Genes when used");
        } else {
            aList.add(LH.Chat.PURPLE + "Level:" + LH.Chat._PINK + (((aMeta / 10) % 10) + 1) + LH.Chat._WHITE + "of" + LH.Chat._PINK + 4);
            if (aMeta % 10 < 5) {
                aList.add(LH.Chat.RED + "Not scanned yet!");
            } else {
                aList.add(LH.Chat.CYAN + "Humidity:" + LH.Chat._WHITE + Util.getHumidityMin(aBumbleTag) + " to " + Util.getHumidityMax(aBumbleTag) + LH.Chat.RED + "   Temp:" + LH.Chat._WHITE + Util.getTemperatureMin(aBumbleTag) + "K to " + Util.getTemperatureMax(aBumbleTag) + "K");
                aList.add(LH.Chat.GREEN + "Offspring:" + LH.Chat._WHITE + Util.getOffspring(aBumbleTag) + LH.Chat.ORANGE + "   Life:" + LH.Chat._WHITE + Util.getLifeSpan(aBumbleTag) + " ticks");
                aList.add(LH.Chat.YELLOW + "Eff:" + LH.Chat._WHITE + LH.percent(Util.getWorkForce(aBumbleTag)) + "%" + LH.Chat.RED + "   Aggro:" + LH.Chat._WHITE + LH.percent(Util.getAggressiveness(aBumbleTag)) + "%");
                if (Util.getDayActive(aBumbleTag)) {
                    if (Util.getNightActive(aBumbleTag)) {
                        aList.add(LH.Chat.RAINBOW + "Doesn't take breaks");
                    } else {
                        aList.add(LH.Chat.PURPLE + "Works at Day");
                    }
                } else {
                    if (Util.getNightActive(aBumbleTag)) {
                        aList.add(LH.Chat.PURPLE + "Works at Night");
                    } else {
                        aList.add(LH.Chat.BLINKING_RED + "Doesn't work at any Time (BUG!!!)");
                    }
                }

                if (Util.getRainproof(aBumbleTag)) {
                    if (Util.getStormproof(aBumbleTag)) {
                        aList.add(LH.Chat.RAINBOW + "Can fly during any Weather");
                    } else {
                        aList.add(LH.Chat.PURPLE + "Can fly during Rain, but not during Storms");
                    }
                } else {
                    if (Util.getStormproof(aBumbleTag)) {
                        aList.add(LH.Chat.PURPLE + "Can fly during Storms, but not when it Rains");
                    } else {
                        aList.add(LH.Chat.RED + "Weak to Weather");
                    }
                }

                if (Util.getOutsideActive(aBumbleTag)) {
                    if (Util.getInsideActive(aBumbleTag)) {
                        aList.add(LH.Chat.RAINBOW + "Doesn't care whether to bee In- or Outside");
                    } else {
                        aList.add(LH.Chat.PURPLE + "Needs to bee Outside");
                    }
                } else {
                    if (Util.getInsideActive(aBumbleTag)) {
                        aList.add(LH.Chat.PURPLE + "Needs to bee Inside");
                    } else {
                        aList.add(LH.Chat.BLINKING_RED + "Doesn't work anywhere (BUG!!!)");
                    }
                }
            }
        }
    }

    @Override
    public ItemStack bumbleScan(ItemStack aBumbleBee) {
        ItemStack rStack = ST.copy(aBumbleBee);
        short aMeta = ST.meta_(rStack);
        if (aMeta % 10 < 5) ST.meta_(rStack, aMeta + 5);
        return rStack;
    }

    @Override
    public ItemStack bumbleKill(ItemStack aBumbleBee) {
        ItemStack rStack = ST.copy(aBumbleBee);
        short aMeta = ST.meta_(rStack);
        if (aMeta % 5 != 4) ST.meta_(rStack, (aMeta / 5) * 5 + 4);
        return rStack;
    }

    @Override
    public ItemStack bumbleCrown(ItemStack aBumbleBee) {
        ItemStack rStack = ST.copy(aBumbleBee);
        short aMeta = ST.meta_(rStack);
        if (aMeta % 5 != 2) ST.meta_(rStack, (aMeta / 5) * 5 + 2);
        return rStack;
    }

    @Override
    public boolean bumbleEqual(ItemStack aBumbleBeeA, short aMetaDataA, ItemStack aBumbleBeeB, short aMetaDataB) {
        return aBumbleBeeA.getItem() == aBumbleBeeB.getItem() && aMetaDataA / 10 == aMetaDataB / 10;
    }

    @Override
    public byte bumbleType(ItemStack aBumbleBee) {
        return (byte) (ST.meta_(aBumbleBee) % 10);
    }

    @Override
    public ItemStack bumbleDrone(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10);
    }

    @Override
    public ItemStack bumblePrincess(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 1);
    }

    @Override
    public ItemStack bumbleQueen(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 2);
    }

    @Override
    public ItemStack bumbleDead(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 4);
    }

    @Override
    public ItemStack bumbleDrone_(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 5);
    }

    @Override
    public ItemStack bumblePrincess_(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 6);
    }

    @Override
    public ItemStack bumbleQueen_(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 7);
    }

    @Override
    public ItemStack bumbleDead_(ItemStack aBumbleBee, short aMetaData) {
        return ST.make(this, 1, (aMetaData / 10) * 10 + 9);
    }

    @Override
    public int getDefaultStackLimit(ItemStack aStack) {
        return 64;
    }

    public static boolean checkFlowers(World aWorld, int aX, int aY, int aZ) {
        Block aBlock = WD.block(aWorld, aX, aY, aZ, F);
        if (aBlock == NB) return F;
        if (aBlock == Blocks.flower_pot) {
            TileEntity tTileEntity = WD.te(aWorld, aX, aY, aZ, F);
            if (tTileEntity instanceof TileEntityFlowerPot) {
                aBlock = Block.getBlockFromItem(((TileEntityFlowerPot) tTileEntity).getFlowerPotItem());
                return aBlock == Blocks.yellow_flower || aBlock == Blocks.red_flower;
            }
            return F;
        }
        if (aBlock == Blocks.double_plant) {
            byte tMeta = WD.meta(aWorld, aX, aY, aZ);
            return tMeta != 2 && tMeta != 3;
        }
        if (BlocksGT.FLOWERS.contains(aBlock)) {
            Block tBlock = WD.block(aWorld, aX, aY - 1, aZ);
            if (aBlock == tBlock || aBlock == WD.block(aWorld, aX, aY + 1, aZ)) return F;
            int tX = aX + RNGSUS.nextInt(5) - 2, tY = aY + RNGSUS.nextInt(3) - 2, tZ = aZ + RNGSUS.nextInt(5) - 2;
            if (tBlock == WD.block(aWorld, tX, tY, tZ)) {
                tBlock = WD.block(aWorld, tX, ++tY, tZ);
                byte tMeta = WD.meta(aWorld, aX, aY, aZ);
                if (WD.air(aWorld, tX, tY, tZ, tBlock) || WD.grass(tBlock, tMeta)) {
                    WD.set(aWorld, tX, tY, tZ, aBlock, tMeta, 3);
                }
            }
            return T;
        }
        return F;
    }

    public IIcon PRINCESS, QUEEN, SCANNED, DEAD;

    @Override
    public IIcon getIconIndex(ItemStack aStack) {
        return getIconFromDamage(ST.meta(aStack));
    }

    @Override
    public IIcon getIconFromDamage(int aMetaData) {
        aMetaData /= 10;
        aMetaData *= 10;
        return UT.Code.exists(aMetaData, mIconList) ? mIconList[aMetaData][0] : Textures.ItemIcons.RENDERING_ERROR.getIcon(0);
    }

    @Override
    public IIcon getIcon(ItemStack aStack, int aRenderPass, EntityPlayer aPlayer, ItemStack aUsedStack, int aUseRemaining) {
        return getIcon(aStack, aRenderPass);
    }

    @Override
    public IIcon getIcon(ItemStack aStack, int aRenderPass) {
        return getIconFromDamageForRenderPass(ST.meta_(aStack), aRenderPass);
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return T;
    }

    @Override
    public int getRenderPasses(int aMetaData) {
        switch (aMetaData % 10) {
            case 6:
            case 7:
            case 8:
            case 9:
                return 3;
            case 1:
            case 2:
            case 4:
            case 5:
                return 2;
            default:
                return 1;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister aIconRegister) {
        PRINCESS = aIconRegister.registerIcon(mModID + ":" + getUnlocalizedName() + "/overlay_princess");
        QUEEN = aIconRegister.registerIcon(mModID + ":" + getUnlocalizedName() + "/overlay_queen");
        SCANNED = aIconRegister.registerIcon(mModID + ":" + getUnlocalizedName() + "/overlay_scanned");
        DEAD = aIconRegister.registerIcon(mModID + ":" + getUnlocalizedName() + "/overlay_dead");

        for (short aMeta = 0, tMaxMeta = (short) mEnabledItems.length(); aMeta < tMaxMeta; aMeta += 10)
            if (mEnabledItems.get(aMeta)) {
                mIconList[aMeta][0] = aIconRegister.registerIcon(mModID + ":" + getUnlocalizedName() + "/" + aMeta);
            }
    }

    @Override
    public IIcon getIconFromDamageForRenderPass(int aMetaData, int aRenderPass) {
        if (aRenderPass == 0) return getIconFromDamage(aMetaData);
        if (aRenderPass == 1) {
            switch (aMetaData % 10) {
                case 1:
                case 6:
                    return PRINCESS;
                case 2:
                case 7:
                    return QUEEN;
                case 3:
                case 8:
                    return DEAD;
                case 4:
                case 9:
                    return DEAD;
            }
        }
        return SCANNED;
    }
}