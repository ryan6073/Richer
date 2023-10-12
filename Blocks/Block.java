package com.github.ryan6073.Richer.Blocks;
import com.github.ryan6073.Richer.Players.*;

// Block.java

import com.github.ryan6073.Richer.Players.Dir;

import java.util.ArrayList;
import java.util.List;

// 可选接口
interface IBlock {
    void draw();
    boolean enterBy(Player player);

}
interface ICloneableBlock {
    ICloneableBlock clone();
}

public abstract class Block implements IBlock,ICloneableBlock {
    private int mX;
    private int mY;
    private Block[] mNeighbors = new Block[Dir.TOTAL_COUNT];
    private List<Dir.Direction> mNeighborDirs = new ArrayList<>();

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public void setXY(int x, int y) {
        mX = x;
        mY = y;
    }

    public Block getNeighbor(Dir.Direction d) {
        if (d == Dir.Direction.UNKNOW) return null;
        return mNeighbors[d.ordinal()];
    }

    public List<Dir.Direction> getNeighborDirs() {
        return mNeighborDirs;
    }
    public void setNeighbor(Dir.Direction d, Block b) {
        if (d == Dir.Direction.UNKNOW) return;
        mNeighbors[d.ordinal()] = b;
        if (b != null) {
            mNeighborDirs.add(d);
        }
    }

    public boolean isLinked(Dir.Direction d) {
        if (d == Dir.Direction.UNKNOW) return false;
        return mNeighbors[d.ordinal()] != null;
    }

    public abstract void draw();
    public abstract Block clone();
    @Override
    public abstract boolean enterBy(Player player);

    public Block() {
        // 默认构造函数
    }
    protected Block(Block other) {
        this.mX = 0;
        this.mY = 0;
        //this.mNeighbors = new Block[Dir.TOTAL_COUNT];
        for (int d = Dir.Direction.LEFT.ordinal(); d < Dir.TOTAL_COUNT; d++) {
            this.mNeighbors[d] = null;
        }
        mNeighborDirs.clear();
    }



}

