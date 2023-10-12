package com.github.ryan6073.Richer.Maps;

import com.github.ryan6073.Richer.Blocks.IBlockFactory;
// IMapFactory.java

public interface    IMapFactory {
    Map createMap(MapID.Value id, IBlockFactory fac);
}
