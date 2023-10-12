package com.github.ryan6073.Richer.Maps;

// MapMgr.java

import com.github.ryan6073.Richer.Blocks.IBlockFactory;

import java.util.Optional;

public class MapMgr {
    private static final MapMgr instance = new MapMgr();
    private Map mCurMap ;

    private MapMgr() {
    }
    public static MapMgr getInstance() {
        return instance;
    }

    public Map activedMap() {
        return mCurMap;
    }

    public void setActiveMap(MapID.Value mapID, IMapFactory mapFac, IBlockFactory blockFac) {
        mCurMap = mapFac.createMap(mapID, blockFac);
    }
    public void setActiveMap(MapID.Value mapID) {
        MapBuilder builder = null;
        MapDirector director = null;

        if (mapID == MapID.Value.TOWN_MAP) {
            builder = new CommonMapBuilder();
            director = new TownMapDirector(builder);
        } else if (mapID == MapID.Value.CITY_MAP) {
            builder = new CommonMapBuilder();
            director = new CityMapDirector(builder);
        } else {
            return;
        }

        mCurMap = director.makeMap();
    }
}
