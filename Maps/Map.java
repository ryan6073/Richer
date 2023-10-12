package com.github.ryan6073.Richer.Maps;

import java.util.ArrayList;
import java.util.List;
import com.github.ryan6073.Richer.Blocks.Block;
import com.github.ryan6073.Richer.IO.IO;

public class Map implements IMap {
    private final List<Block> blocks = new ArrayList<>();

    @Override
    public void show() {
        IO.println("\n");
        int lastX = 1;
        int lastY = 0;
        for (Block block : blocks) {
            int curX = block.getX();
            int curY = block.getY();

            while (lastY < curY) {
                IO.println("\n\t");
                ++lastY;
                lastX = 1;
            }
            while (lastX < curX) {
                IO.print("   ");
                ++lastX;
            }
            block.draw();
            lastX = curX + 1;
        }
        IO.println("\n\n");
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Block getBlockByIndex(int index) {
        if (index >= 0 && index < blocks.size()) {
            return blocks.get(index);
        }
        return null;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }
}
