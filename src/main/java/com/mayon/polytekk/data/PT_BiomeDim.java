package com.mayon.polytekk.data;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.MD;
import gregapi.util.UT;
import gregapi.worldgen.WorldgenObject;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

import java.util.List;

public class PT_BiomeDim {


    public static final int
        DIM_MOHO = 20
        , DIM_EVE = 18
        , DIM_MUN = 15
        , DIM_MINMUS = 21
        , DIM_DUNA = 16
        , DIM_DRES = 19
        , DIM_IKE = 17
        , DIM_LAYTHE = 22
        , DIM_TEKTO = 24
        ;

    public static boolean dimMoho(World aWorld) {return aWorld != null && dimMoho(aWorld.provider);}

    public static boolean dimMoho(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimMoho(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimMoho(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderMoho".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimEve(World aWorld) {return aWorld != null && dimEve(aWorld.provider);}
    public static boolean dimEve(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimEve(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimEve(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderEve".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimMun(World aWorld) {return aWorld != null && dimMun(aWorld.provider);}
    public static boolean dimMun(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimMun(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimMun(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderMoon".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimMinmus(World aWorld) {return aWorld != null && dimMinmus(aWorld.provider);}
    public static boolean dimMinmus(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimMinmus(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimMinmus(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderMinmus".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimDuna(World aWorld) {return aWorld != null && dimDuna(aWorld.provider);}
    public static boolean dimDuna(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimDuna(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimDuna(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderDuna".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimDres(World aWorld) {return aWorld != null && dimDres(aWorld.provider);}
    public static boolean dimDres(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimDres(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimDres(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderDres".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimIke(World aWorld) {return aWorld != null && dimIke(aWorld.provider);}
    public static boolean dimIke(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimIke(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimIke(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderIke".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimLaythe(World aWorld) {return aWorld != null && dimLaythe(aWorld.provider);}
    public static boolean dimLaythe(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimLaythe(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimLaythe(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderLaythe".equalsIgnoreCase(aProviderClassName);}

    public static boolean dimTekto(World aWorld) {return aWorld != null && dimTekto(aWorld.provider);}
    public static boolean dimTekto(WorldProvider aProvider) {return (MD.HBM.mLoaded) && dimTekto(aProvider, UT.Reflection.getLowercaseClass(aProvider));}
    public static boolean dimTekto(WorldProvider aProvider, String aProviderClassName) {return MD.HBM.mLoaded && "WorldProviderTekto".equalsIgnoreCase(aProviderClassName);}

    @SuppressWarnings("unchecked")
    public static final List<WorldgenObject>
        GEN_MOHO         = new ArrayListNoNulls<>()
        , GEN_EVE         = new ArrayListNoNulls<>()
        , GEN_MUN         = new ArrayListNoNulls<>()
        , GEN_MINMUS         = new ArrayListNoNulls<>()
        , GEN_DUNA         = new ArrayListNoNulls<>()
        , GEN_IKE         = new ArrayListNoNulls<>()
        , GEN_DRES         = new ArrayListNoNulls<>()
        , GEN_LAYTHE         = new ArrayListNoNulls<>()
        , GEN_TEKTO         = new ArrayListNoNulls<>()
        , GEN_KERBIN[]            = new List[] {GEN_MUN, GEN_MINMUS}
        , GEN_INNER_KERBOL[]           = new List[] {GEN_MOHO, GEN_EVE, GEN_MUN, GEN_MINMUS, GEN_DUNA, GEN_IKE, GEN_DRES}
        , GEN_OUTER_KERBOL[]             = new List[] {GEN_LAYTHE, GEN_TEKTO}
        , GEN_KERBOL_ALL[]             = new List[] {GEN_MOHO, GEN_EVE, GEN_MUN, GEN_MINMUS, GEN_DUNA, GEN_IKE, GEN_DRES, GEN_LAYTHE, GEN_TEKTO}
        ;

    /** Lists of all the active Large Ore Vein generation by Dimension Type, these are getting initialised in Load! */
    @SuppressWarnings("unchecked")
    public static final List<WorldgenObject>
        ORE_MOHO         = new ArrayListNoNulls<>()
        , ORE_EVE         = new ArrayListNoNulls<>()
        , ORE_MUN         = new ArrayListNoNulls<>()
        , ORE_MINMUS         = new ArrayListNoNulls<>()
        , ORE_DUNA         = new ArrayListNoNulls<>()
        , ORE_IKE         = new ArrayListNoNulls<>()
        , ORE_DRES         = new ArrayListNoNulls<>()
        , ORE_LAYTHE         = new ArrayListNoNulls<>()
        , ORE_TEKTO         = new ArrayListNoNulls<>()
        , ORE_KERBIN[]            = new List[] {ORE_MUN, ORE_MINMUS}
        , ORE_INNER_KERBOL[]           = new List[] {ORE_MOHO, ORE_EVE, ORE_MUN, ORE_MINMUS, ORE_DUNA, ORE_IKE, ORE_DRES}
        , ORE_OUTER_KERBOL[]             = new List[] {ORE_LAYTHE, ORE_TEKTO}
        , ORE_KERBOL_ALL[]             = new List[] {ORE_MOHO, ORE_EVE, ORE_MUN, ORE_MINMUS, ORE_DUNA, ORE_IKE, ORE_DRES, ORE_LAYTHE, ORE_TEKTO}

        ;


}
