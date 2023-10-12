package com.github.ryan6073.Richer.Maps;

import com.github.ryan6073.Richer.Blocks.Block;
import com.github.ryan6073.Richer.Blocks.BlockType;
import com.github.ryan6073.Richer.Blocks.IBlockFactory;
import com.github.ryan6073.Richer.Players.Dir;

import java.util.ArrayList;
import java.util.List;

public class MapFactory {
    private static final MapFactory instance = new MapFactory();
    private MapBuilder pBuilder;

    private MapFactory() {
    }

    public static MapFactory getInstance() {
        return instance;
    }

    public void setBuilder(MapBuilder p) {
        this.pBuilder = p;
    }

    public Map createMap(MapID.Value id, IBlockFactory fac) {
        List<List<Integer>> data = null;

        if (id == MapID.Value.TOWN_MAP) {
            // 口字形地图，共8个Block
            data = new ArrayList<List<Integer>>() {{
                add(List.of(1, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 2, 0, 4, 0, 1, 1));
                add(List.of(2, BlockType.Type.NORMAL_BLOCK.ordinal(), 1, 3, 0, 0, 0, 2, 1));
                // 添加其他行数据...
            }};
        } else if (id == MapID.Value.CITY_MAP) {
            // 城市地图数据
            data = new ArrayList<List<Integer>>() {{
                add(List.of(1, BlockType.Type.MONEY_BLOCK.ordinal(), 0, 2, 0, 6, 0, 1, 1));
                add(List.of(2, BlockType.Type.MONEY_BLOCK.ordinal(), 1, 3, 0, 0, 0, 2, 1));
                // 添加其他行数据...
            }};
        }

        if (data == null) {
            return null;
        }

        Map pMap = new Map();
        for (List<Integer> row : data) {
            Block pB = fac.createBlock(BlockType.Type.values()[row.get(1)]);
            pB.setXY(row.get(7), row.get(8));
            pMap.addBlock(pB);
        }

        for (List<Integer> row : data) {
            int index = row.get(0) - 1;
            Block center = pMap.getBlockByIndex(index);
            Block neighbor;

            if (row.get(2) > 0) {
                neighbor = pMap.getBlockByIndex(row.get(2) - 1);
                center.setNeighbor(Dir.Direction.LEFT, neighbor);
            }

            if (row.get(3) > 0) {
                neighbor = pMap.getBlockByIndex(row.get(3) - 1);
                center.setNeighbor(Dir.Direction.RIGHT, neighbor);
            }

            // 添加其他方向的邻居设置...

        }

        return pMap;
    }
}
