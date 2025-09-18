package com.mayon.polytekk.data;

import com.hbm.config.SpaceConfig;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.MD;
import gregapi.util.UT;
import gregapi.worldgen.WorldgenObject;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

import java.util.List;

public class PT_BiomeDim {

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
