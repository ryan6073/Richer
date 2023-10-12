package com.github.ryan6073.Richer.Maps;

import com.github.ryan6073.Richer.Blocks.BlockProtoFactory;
import com.github.ryan6073.Richer.Blocks.IBlockFactory;
import com.github.ryan6073.Richer.Blocks.Block;
import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Blocks.BlockType;
import java.util.ArrayList;
import java.util.List;

public interface MapBuilder {
    //Map pMap = null;
    void buildMap();
    void buildBlock(BlockType.Type type, int x, int y);
    void setLink(Dir.Direction d, int fromID, int toID);
    Map getMap();
}
class CommonMapBuilder implements MapBuilder {
    private Map mpMap;
    @Override
    public void buildMap() {
        mpMap = new Map();
    }

    @Override
    public void buildBlock(BlockType.Type type, int x, int y) {
        Block block = BlockProtoFactory.getInstance().createBlock(type);
        block.setXY(x, y);
        mpMap.addBlock(block);
    }

    @Override
    public void setLink(Dir.Direction d, int fromID, int toID) {
        assert fromID >= 1;
        if (toID <= 0) return;

        Block self = mpMap.getBlockByIndex(fromID - 1);
        Block dest = mpMap.getBlockByIndex(toID - 1);
        self.setNeighbor(d, dest);
    }

    @Override
    public Map getMap() {
        return mpMap;
    }
}
