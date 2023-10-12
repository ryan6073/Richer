package com.github.ryan6073.Richer.Blocks;

// BlockType.java

public class BlockType {
    public enum Type {
        NORMAL_BLOCK,
        MONEY_BLOCK,
        TRIP_BLOCK,
        BAR_BLOCK
    }

    public static final int TOTAL_COUNT = Type.values().length;
}
