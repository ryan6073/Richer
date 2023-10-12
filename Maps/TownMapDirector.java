package com.github.ryan6073.Richer.Maps;

import com.github.ryan6073.Richer.Blocks.BlockType;
import com.github.ryan6073.Richer.Players.Dir;

import java.util.ArrayList;
import java.util.List;

public class TownMapDirector extends MapDirector {
    public TownMapDirector(MapBuilder builder) {
        super(builder);
    }

    @Override
    public Map makeMap() {
        // Data format, for example, a "口" shape with 8 blocks
        // Each row: {ID, type, left, right, up, down, initial value, posX, posY}
        List<List<Integer>> data = new ArrayList<>();
        data.add(List.of(1, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 2, 0, 4, 0, 1, 1));
        data.add(List.of(2, BlockType.Type.NORMAL_BLOCK.ordinal(), 1, 3, 0, 0, 0, 2, 1));
        data.add(List.of(3, BlockType.Type.NORMAL_BLOCK.ordinal(), 2, 0, 0, 5, 0, 3, 1));
        data.add(List.of(4, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 0, 1, 6, 0, 1, 2));
        data.add(List.of(5, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 0, 3, 8, 0, 3, 2));
        data.add(List.of(6, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 7, 4, 0, 0, 1, 3));
        data.add(List.of(7, BlockType.Type.NORMAL_BLOCK.ordinal(), 6, 8, 0, 0, 0, 2, 3));
        data.add(List.of(8, BlockType.Type.NORMAL_BLOCK.ordinal(), 7, 0, 5, 0, 0, 3, 3));

        mpBuilder.buildMap();

        for (List<Integer> row : data) {
            mpBuilder.buildBlock(BlockType.Type.values()[row.get(1)], row.get(7), row.get(8));
        }

        for (List<Integer> row : data) {
            mpBuilder.setLink(Dir.Direction.LEFT, row.get(0), row.get(2));
            mpBuilder.setLink(Dir.Direction.RIGHT, row.get(0), row.get(3));
            mpBuilder.setLink(Dir.Direction.UP, row.get(0), row.get(4));
            mpBuilder.setLink(Dir.Direction.DOWN, row.get(0), row.get(5));
        }

        return mpBuilder.getMap();
    }
}
