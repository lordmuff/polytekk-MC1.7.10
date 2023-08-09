//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mayon.polytekk.items;

import gregapi.code.TagData;
import gregapi.data.TD.Atomic;
import gregapi.data.TD.Processing;
import gregapi.item.multiitem.MultiItemRandom;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

public class PTParticleRegistry {
    public static MultiItemRandom PHYS;
    public static final OreDictMaterial v;
    public static final OreDictMaterial Neutrino;
    public static final OreDictMaterial vanti;
    public static final OreDictMaterial Anti_Neutrino;
    public static final OreDictMaterial n;
    public static final OreDictMaterial Neutron;
    public static final OreDictMaterial nanti;
    public static final OreDictMaterial Anti_Neutron;
    public static final OreDictMaterial p;
    public static final OreDictMaterial Proton;
    public static final OreDictMaterial panti;
    public static final OreDictMaterial Anti_Proton;
    public static final OreDictMaterial e;
    public static final OreDictMaterial Electron;
    public static final OreDictMaterial eanti;
    public static final OreDictMaterial Positron;
    public static final OreDictMaterial HB;
    public static final OreDictMaterial Higgs_Boson;
    public static final OreDictMaterial y;
    public static final OreDictMaterial Photon;

    public PTParticleRegistry() {
    }// 13

    static {
        Neutrino = v = OreDictMaterial.createMaterial(1, "Neutrino", "Neutrino").setStatsElement(0L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(0L, 200L, 200L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("ve").hide();// 17
        Anti_Neutrino = vanti = OreDictMaterial.createMaterial(2, "Anti_Neutrino", "Anti-Neutrino").setStatsElement(0L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 55L, 55L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("ve-").hide();// 18
        Neutron = n = OreDictMaterial.createMaterial(3, "Neutron", "Neutron").setStatsElement(0L, 0L, 1L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(0L, 0L, 255L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("n").hide();// 19
        Anti_Neutron = nanti = OreDictMaterial.createMaterial(4, "Anti_Neutron", "Anti-Neutron").setStatsElement(0L, 0L, 1L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(0L, 0L, 255L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("n-").hide();// 20
        Proton = p = OreDictMaterial.createMaterial(5, "Proton", "Proton").setStatsElement(1L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 0L, 0L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE, Processing.FUSION}).tooltip("p").hide();// 21
        Anti_Proton = panti = OreDictMaterial.createMaterial(6, "Anti_Proton", "Anti-Proton").setStatsElement(1L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 0L, 0L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE, Processing.FUSION}).tooltip("p-").hide();// 22
        Electron = e = OreDictMaterial.createMaterial(7, "Electron", "Electron").setStatsElement(0L, 1L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 255L, 255L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("e-").hide();// 23
        Positron = eanti = OreDictMaterial.createMaterial(8, "Positron", "Positron").setStatsElement(0L, 1L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(0L, 0L, 0L, 0L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("e+").hide();// 24
        Higgs_Boson = HB = OreDictMaterial.createMaterial(9, "Higgs_Boson", "Higg's Boson").setStatsElement(0L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 255L, 255L, 255L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("H0").hide();// 25
        Photon = y = OreDictMaterial.createMaterial(10, "Photon", "Photon").setStatsElement(0L, 0L, 0L, 0L, 0.0).heat(0L, 0L, 0L).setRGBa(255L, 255L, 255L, 255L).setTextures(TextureSet.SET_NONE).put(new TagData[]{Atomic.PARTICLE}).tooltip("y").hide();// 26
    }
}
