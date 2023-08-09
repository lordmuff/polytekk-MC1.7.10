//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mayon.polytekk.tileentity.multiblocks;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockMachine;
import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController.Util;
import java.util.List;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

public class MultiTileEntityParticleCollider extends TileEntityBase10MultiBlockMachine {
    public static boolean[][][] OCTAGONS = new boolean[][][]{{{false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false}, {false, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false}, {false, false, false, true, false, false, false, true, true, true, true, true, false, false, false, true, false, false, false}, {false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, false}, {false, true, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, true, false}, {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true}, {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true}, {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true}, {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true}, {true, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true}, {false, true, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, true, false}, {false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, false}, {false, false, false, true, false, false, false, true, true, true, true, true, false, false, false, true, false, false, false}, {false, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false}, {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}}, {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, true, false, true, true, true, true, true, false, true, false, false, false, false, false}, {false, false, false, false, true, false, true, false, false, false, false, false, true, false, true, false, false, false, false}, {false, false, false, true, false, true, false, false, false, false, false, false, false, true, false, true, false, false, false}, {false, false, true, false, true, false, false, false, false, false, false, false, false, false, true, false, true, false, false}, {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false}, {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false}, {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false}, {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false}, {false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false}, {false, false, true, false, true, false, false, false, false, false, false, false, false, false, true, false, true, false, false}, {false, false, false, true, false, true, false, false, false, false, false, false, false, true, false, true, false, false, false}, {false, false, false, false, true, false, true, false, false, false, false, false, true, false, true, false, false, false, false}, {false, false, false, false, false, true, false, true, true, true, true, true, false, true, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}}, {{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false}, {false, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false}, {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false}, {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false}, {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false}, {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false}, {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false}, {false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false}, {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false}, {false, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false}, {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false}, {false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false}, {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}}};

    public MultiTileEntityParticleCollider() {
    }// 42

    public boolean checkStructure2() {
        int tX = this.getOffsetXN(this.mFacing, 2);// 45
        int tY = this.field_145848_d;
        int tZ = this.getOffsetZN(this.mFacing, 2);
        if (this.field_145850_b.func_72899_e(tX - 9, tY, tZ - 9) && this.field_145850_b.func_72899_e(tX + 9, tY, tZ - 9) && this.field_145850_b.func_72899_e(tX - 9, tY, tZ + 9) && this.field_145850_b.func_72899_e(tX + 9, tY, tZ + 9)) {// 46
            boolean tSuccess = true;// 47
            int tVersatile = 3;// 49
            int tLogic = 12;
            int tControl = 12;

            int i;
            int j;
            for(i = -2; i <= 2; ++i) {
                for(j = -2; j <= 2; ++j) {
                    for(int k = -2; k <= 2; ++k) {// 51
                        if (i * i + j * j + k * k < 4) {// 52
                            if (Util.checkAndSetTarget(this, tX + i, tY + j, tZ + k, 18200, this.getMultiTileEntityRegistryID(), 0, -1)) {// 53
                                --tVersatile;// 54
                            } else if (Util.checkAndSetTarget(this, tX + i, tY + j, tZ + k, 18201, this.getMultiTileEntityRegistryID(), 0, -1)) {// 55
                                --tLogic;// 56
                            } else if (Util.checkAndSetTarget(this, tX + i, tY + j, tZ + k, 18202, this.getMultiTileEntityRegistryID(), 0, -1)) {// 57
                                --tControl;// 58
                            } else {
                                tSuccess = false;// 60
                            }
                        } else if (i * i + j * j + k * k <= 6 && (j != 0 || (i != -2 && i != 2 || k != 0) && (k != -2 && k != 2 || i != 0))) {// 62
                            if (!Util.checkAndSetTarget(this, tX + i, tY + j, tZ + k, 18299, this.getMultiTileEntityRegistryID(), 0, -1)) {// 65
                                tSuccess = false;
                            }
                        } else if (!Util.checkAndSetTarget(this, tX + i, tY + j, tZ + k, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 63
                            tSuccess = false;
                        }
                    }
                }
            }

            if (tVersatile > 0 || tLogic > 0 || tControl > 0) {// 69
                tSuccess = false;
            }

            if (this.mFacing != 4) {// 71
                if (!Util.checkAndSetTarget(this, tX - 3, tY, tZ, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 72
                    tSuccess = false;
                }

                if (!Util.checkAndSetTarget(this, tX - 4, tY, tZ, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 73
                    tSuccess = false;
                }
            }

            if (this.mFacing != 5) {// 75
                if (!Util.checkAndSetTarget(this, tX + 3, tY, tZ, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 76
                    tSuccess = false;
                }

                if (!Util.checkAndSetTarget(this, tX + 4, tY, tZ, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 77
                    tSuccess = false;
                }
            }

            if (this.mFacing != 2) {// 79
                if (!Util.checkAndSetTarget(this, tX, tY, tZ - 3, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 80
                    tSuccess = false;
                }

                if (!Util.checkAndSetTarget(this, tX, tY, tZ - 4, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 81
                    tSuccess = false;
                }
            }

            if (this.mFacing != 3) {// 83
                if (!Util.checkAndSetTarget(this, tX, tY, tZ + 3, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 84
                    tSuccess = false;
                }

                if (!Util.checkAndSetTarget(this, tX, tY, tZ + 4, 18008, this.getMultiTileEntityRegistryID(), 0, -1)) {// 85
                    tSuccess = false;
                }
            }

            tX -= 9;// 88
            tZ -= 9;

            for(i = 0; i < 19; ++i) {
                for(j = 0; j < 19; ++j) {// 90
                    if (OCTAGONS[0][i][j]) {// 91
                        if (!Util.checkAndSetTarget(this, tX + i, tY - 1, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 92
                            tSuccess = false;
                        }

                        if (i == 9 && (j == 0 || j == 18) || j == 9 && (i == 0 || i == 18)) {// 93
                            if (!Util.checkAndSetTarget(this, tX + i, tY, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 2, -3)) {// 94
                                tSuccess = false;
                            }
                        } else if (!Util.checkAndSetTarget(this, tX + i, tY, tZ + j, 18002, this.getMultiTileEntityRegistryID(), this.mActive ? 6 : 5, -3)) {// 96
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY + 1, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 98
                            tSuccess = false;
                        }
                    }

                    if (OCTAGONS[1][i][j]) {// 100
                        if (!Util.checkAndSetTarget(this, tX + i, tY - 2, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 101
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY - 1, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -1)) {// 103
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY, tZ + j, 18046, this.getMultiTileEntityRegistryID(), 0, -1)) {// 105
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY + 1, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -1)) {// 107
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY + 2, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 109
                            tSuccess = false;
                        }
                    }

                    if (OCTAGONS[2][i][j]) {// 111
                        if (!Util.checkAndSetTarget(this, tX + i, tY - 2, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 112
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY - 1, tZ + j, 18046, this.getMultiTileEntityRegistryID(), 0, -1)) {// 114
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -1)) {// 116
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY + 1, tZ + j, 18046, this.getMultiTileEntityRegistryID(), 0, -1)) {// 118
                            tSuccess = false;
                        }

                        if (!Util.checkAndSetTarget(this, tX + i, tY + 2, tZ + j, 18002, this.getMultiTileEntityRegistryID(), 0, -61)) {// 120
                            tSuccess = false;
                        }
                    }
                }
            }

            return tSuccess;// 123
        } else {
            return this.mStructureOkay;// 125
        }
    }

    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get("gt.lang.structure") + ":");// 202
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.1"));// 203
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.2"));// 204
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.3"));// 205
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.4"));// 206
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.5"));// 207
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.6"));// 208
        aList.add(Chat.WHITE + LH.get("gt.tooltip.multiblock.particlecollider.7"));// 209
        super.addToolTips(aList, aStack, aF3_H);// 210
    }// 211

    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int tX = this.getOffsetXN(this.mFacing, 2);// 215
        int tY = this.field_145848_d - 2;
        int tZ = this.getOffsetZN(this.mFacing, 2);
        return aX >= tX - 9 && aY >= tY && aZ >= tZ - 9 && aX <= tX + 9 && aY <= tY + 5 && aZ <= tZ + 9;// 216
    }

    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        return null;// 221
    }

    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        return null;// 226
    }

    public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
        return null;// 229
    }

    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;// 230
    }

    public boolean refreshStructureOnActiveStateChange() {
        return true;// 232
    }

    public String getTileEntityName() {
        return "gt.multitileentity.multiblock.particlecollider";// 234
    }

    static {
        LH.add("gt.tooltip.multiblock.particlecollider.1", "For Construction Instructions read the Manual or the GUI.");// 191
        LH.add("gt.tooltip.multiblock.particlecollider.2", "144 Superconducting Coils, 576 Regular Osmiridium Walls, 50 Ventilation Units.");// 192
        LH.add("gt.tooltip.multiblock.particlecollider.3", "36 Regular Stainless Steel Walls, 53 Galvanized Steel Walls.");// 193
        LH.add("gt.tooltip.multiblock.particlecollider.4", "3 Versatile, 12 Logic and 12 Control Quadcore Processing Units.");// 194
        LH.add("gt.tooltip.multiblock.particlecollider.5", "Input energy for start.Then for process");// 195
        LH.add("gt.tooltip.multiblock.particlecollider.6", "Electric power Input at the 'Glass' Ring");// 196
        LH.add("gt.tooltip.multiblock.particlecollider.7", "Items and Fluids are handeled at the normal Walls");// 197
    }// 198
}
