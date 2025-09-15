package com.mayon.polytekk.data;

import gregapi.block.IPrefixBlock;
import gregapi.data.MT;
import gregapi.data.TC;
import gregapi.oredict.OreDictPrefix;
import gregapi.util.OM;

import static gregapi.data.CS.U;
import static gregapi.data.OP.dust;
import static gregapi.data.TD.Prefix.*;

public class PT_Blocks {

    public static class PT_Ores {

        public static IPrefixBlock

            oreMoho, oreEve, oreMinmus, oreDuna, oreDres, oreIke, oreLaythe, oreTekto,
            oreBrokenMoho, oreBrokenEve, oreBrokenMinmus, oreBrokenDuna, oreBrokenDres, oreBrokenIke, oreBrokenLaythe, oreBrokenTekto,
            oreSmallMoho, oreSmallEve, oreSmallMinmus, oreSmallDuna, oreSmallDres, oreSmallIke, oreSmallLaythe, oreSmallTekto;


    }

    private static OreDictPrefix create(String aName, String aCategory, String aPreMaterial, String aPostMaterial) {return OreDictPrefix.createPrefix(aName).setCategoryName(aCategory).setLocalPrefixName(aCategory).setLocalItemName(aPreMaterial, aPostMaterial);}
    private static OreDictPrefix create(String aName, String aCategory) {return OreDictPrefix.createPrefix(aName).setCategoryName(aCategory).setLocalPrefixName(aCategory);}

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static final OreDictPrefix

        oreMoho                 = create("oreMoho"                  , "Moho Ores"                   , "Moho "                            , " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.IGNIS, 2).setTextureSetName("ore"),
        oreEve                 = create("oreEve"                  , "Eve Ores"                   , "Eve "                            , " Ore").setOreStats( 4*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.VENEMUM, 2).setTextureSetName("ore"),
        oreMinmus                 = create("oreMinmus"                  , "Minmus Ores"                   , "Minmus "                            , " Ore").setOreStats( 2*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.GELUM, 2).setTextureSetName("ore"),
        oreDuna                 = create("oreDuna"                  , "Duna Ores"                   , "Duna "                            , " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.METALLUM, 1).setTextureSetName("ore"),
        oreDres                 = create("oreDres"                  , "Dres Ores"                   , "Dres "                            , " Ore").setOreStats( 4*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.NEBRISUM, 1).setTextureSetName("ore"),
        oreIke                 = create("oreIke"                  , "Ike Ores"                   , "Ike "                            , " Ore").setOreStats( 3*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.RADIO, 1).setTextureSetName("ore"),
        oreLaythe                 = create("oreLaythe"                  , "Laythe Ores"                   , "Laythe "                            , " Ore").setOreStats( 5*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.FAMES, 1).setTextureSetName("ore"),
        oreTekto                 = create("oreTekto"                  , "Tekto Ores"                   , "Tekto "                            , " Ore").setOreStats( 5*U ).add(BLOCK_BASED, STANDARD_ORE).aspects(TC.ALIENIS,  1).aspects(TC.RADIO, 1).setTextureSetName("ore");

    static {

        oreMoho                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneMoho     , dust.mAmount * 4));
        oreEve                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneEve     , dust.mAmount * 4));
        oreMinmus                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneMinmus     , dust.mAmount * 4));
        oreDuna                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneDuna     , dust.mAmount * 4));
        oreDres                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneDres     , dust.mAmount * 4));
        oreIke                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneIke     , dust.mAmount * 4));
        oreLaythe                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneLaythe     , dust.mAmount * 4));
        oreTekto                 .mByProducts.add(OM.stack(PT_Material.CelestialStoneTypes.StoneTekto     , dust.mAmount * 4));

    }

}
