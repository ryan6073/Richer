package com.github.ryan6073.Richer.Maps;
import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Blocks.BlockType;
import java.util.ArrayList;
import java.util.List;
public class CityMapDirector extends MapDirector {
    public CityMapDirector(MapBuilder builder) {
        super(builder);
    }

    @Override
    public Map makeMap() {
        // Data format, for example, a "口" shape with 8 blocks
        // Each row: {ID, type, left, right, up, down, initial value, posX, posY}
        List<List<Integer>> data = new ArrayList<>();
        data.add(List.of(1, BlockType.Type.MONEY_BLOCK.ordinal(), 0, 2, 0, 6, 0, 1, 1));
        data.add(List.of(2, BlockType.Type.MONEY_BLOCK.ordinal(), 1, 3, 0, 0, 0, 2, 1));
        data.add(List.of(3, BlockType.Type.MONEY_BLOCK.ordinal(), 2, 4, 0, 7, 0, 3, 1));
        data.add(List.of(4, BlockType.Type.MONEY_BLOCK.ordinal(), 3, 5, 0, 0, 0, 4, 1));
        data.add(List.of(5, BlockType.Type.MONEY_BLOCK.ordinal(), 4, 0, 0, 8, 0, 5, 1));
        data.add(List.of(6, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 0, 1, 9, 0, 1, 2));
        data.add(List.of(7, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 0, 3, 11, 0, 3, 2));
        data.add(List.of(8, BlockType.Type.NORMAL_BLOCK.ordinal(), 0, 0, 5, 13, 0, 5, 2));
        data.add(List.of(9, BlockType.Type.BAR_BLOCK.ordinal(), 0, 10, 6, 14, 0, 1, 3));
        data.add(List.of(10, BlockType.Type.BAR_BLOCK.ordinal(), 9, 11, 0, 0, 0, 2, 3));
        data.add(List.of(11, BlockType.Type.BAR_BLOCK.ordinal(), 10, 12, 7, 15, 0, 3, 3));
        data.add(List.of(12, BlockType.Type.BAR_BLOCK.ordinal(), 11, 13, 0, 0, 0, 4, 3));
        data.add(List.of(13, BlockType.Type.BAR_BLOCK.ordinal(), 12, 0, 8, 16, 0, 5, 3));
        data.add(List.of(14, BlockType.Type.TRIP_BLOCK.ordinal(), 0, 0, 9, 17, 0, 1, 4));
        data.add(List.of(15, BlockType.Type.TRIP_BLOCK.ordinal(), 0, 0, 11, 19, 0, 3, 4));
        data.add(List.of(16, BlockType.Type.TRIP_BLOCK.ordinal(), 0, 0, 13, 21, 0, 5, 4));
        data.add(List.of(17, BlockType.Type.MONEY_BLOCK.ordinal(), 0, 18, 14, 0, 0, 1, 5));
        data.add(List.of(18, BlockType.Type.MONEY_BLOCK.ordinal(), 17, 19, 0, 0, 0, 2, 5));
        data.add(List.of(19, BlockType.Type.MONEY_BLOCK.ordinal(), 18, 20, 15, 0, 0, 3, 5));
        data.add(List.of(20, BlockType.Type.MONEY_BLOCK.ordinal(), 19, 21, 0, 0, 0, 4, 5));
        data.add(List.of(21, BlockType.Type.MONEY_BLOCK.ordinal(), 20, 22, 16, 0, 0, 5, 5));
        data.add(List.of(22, BlockType.Type.MONEY_BLOCK.ordinal(), 21, 23, 0, 0, 0, 6, 5));
        data.add(List.of(23, BlockType.Type.MONEY_BLOCK.ordinal(), 22, 24, 0, 0, 0, 7, 5));
        data.add(List.of(24, BlockType.Type.MONEY_BLOCK.ordinal(), 23, 0, 0, 0, 0, 8, 5));

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
