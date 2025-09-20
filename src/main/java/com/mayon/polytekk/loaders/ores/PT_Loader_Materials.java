package com.mayon.polytekk.loaders.ores;

import gregapi.data.TC;
import gregapi.oredict.OreDictMaterial;

import static gregapi.data.TD.ItemGenerator.G_GEM_ORES_TRANSPARENT;
import static gregapi.data.TD.Properties.CRYSTAL;

public class PT_Loader_Materials {

    public static OreDictMaterial StoneMoho = OreDictMaterial.createMaterial(31200, "Moho", "Moho").aspects(TC.ALIENIS,  1).aspects(TC.IGNIS, 2);
    public static OreDictMaterial StoneEve = OreDictMaterial.createMaterial(31201, "Eve", "Eve").aspects(TC.ALIENIS,  1).aspects(TC.VENEMUM, 2);
    public static OreDictMaterial StoneMinmus = OreDictMaterial.createMaterial(31202, "Minmus", "Minmus").aspects(TC.ALIENIS,  1).aspects(TC.GELUM, 2);
    public static OreDictMaterial StoneDuna = OreDictMaterial.createMaterial(31203, "Duna", "Duna").aspects(TC.ALIENIS,  1).aspects(TC.METALLUM, 1);
    public static OreDictMaterial StoneDres = OreDictMaterial.createMaterial(31204, "Dres", "Dres").aspects(TC.ALIENIS,  1).aspects(TC.LUCRUM, 1);
    public static OreDictMaterial StoneIke = OreDictMaterial.createMaterial(31205, "Ike", "Ike").aspects(TC.ALIENIS,  1).aspects(TC.RADIO, 1);
    public static OreDictMaterial StoneLaythe = OreDictMaterial.createMaterial(31206, "Laythe", "Laythe").aspects(TC.ALIENIS,  1).aspects(TC.FAMES, 1);
    public static OreDictMaterial StoneTekto = OreDictMaterial.createMaterial(31207, "Tekto", "Tekto").aspects(TC.ALIENIS,  1).aspects(TC.FABRICO, 1);
    public static OreDictMaterial Tiberium = OreDictMaterial.createMaterial(31208, "Tiberium", "Tiberium").aspects(TC.RADIO, 4).aspects(TC.VITREUS, 2).put(G_GEM_ORES_TRANSPARENT, CRYSTAL).setPriorityPrefix(1);
    public static OreDictMaterial Australium = OreDictMaterial.createMaterial(31209, "Australium", "Australium");
    public static OreDictMaterial Schrabidium = OreDictMaterial.createMaterial(31210, "Schrabidium", "Schrabidium");
    public static OreDictMaterial Solinium = OreDictMaterial.createMaterial(31211, "Solinium", "Solinium");
    public static OreDictMaterial Euphemium = OreDictMaterial.createMaterial(31212, "Euphemium", "Euphemium");
    public static OreDictMaterial Pb_209 = OreDictMaterial.createMaterial(31213, "Lead209", "Lead-209");
    public static OreDictMaterial Bk_247 = OreDictMaterial.createMaterial(31214, "Berkelium247", "Berkelium-247").aspects_met_rad(5, 6).aspects(TC.NEBRISUM, 2);
    public static OreDictMaterial Es_253 = OreDictMaterial.createMaterial(31215, "Einsteinium253", "Einsteinium-253").aspects_met_rad(5, 23).aspects(TC.NEBRISUM, 3);
    public static OreDictMaterial Molysite = OreDictMaterial.createMaterial(31216, "Molysite", "Molysite").aspects(TC.LIMUS, 3, TC.VENEMUM, 2);
    public static OreDictMaterial Chlorocalcite = OreDictMaterial.createMaterial(31217, "Chlorocalcite", "Chlorocalcite").aspects(TC.VENEMUM, 3, TC.AQUA, 1, TC.TERRA, 1);
    public static OreDictMaterial Volcanic = OreDictMaterial.createMaterial(31218, "Volcanic", "Volcanic Gem").aspects(TC.IGNIS, 5, TC.VINCULUM, 3, TC.VITREUS, 2);
    public static OreDictMaterial Tengam = OreDictMaterial.createMaterial(31219, "TengamRaw", "Tengam").aspects(TC.MAGNETO, 1, TC.ELECTRUM, 4, TC.NEBRISUM, 2);
    public static OreDictMaterial Cf_251 = OreDictMaterial.createMaterial(31220, "Californium251", "Californium-251").aspects_met_rad(3, 11).aspects(TC.IGNIS, 5);
    public static OreDictMaterial Cf_252 = OreDictMaterial.createMaterial(31221, "Californium252", "Californium-252").aspects_met_rad(3, 15).aspects(TC.IGNIS, 9);;

}
