package com.github.ryan6073.Richer.Players;

// Dir.java

public class Dir {
    public enum Direction { LEFT, UP, RIGHT, DOWN, UNKNOW;

        public Direction opposite() {
            if (mDir == Direction.UNKNOW) return Direction.UNKNOW;
            return Direction.values()[(mDir.ordinal() + 2) % TOTAL_COUNT];
        }
    }
    public static final int TOTAL_COUNT = Direction.DOWN.ordinal() + 1;

    private static Direction mDir;

    public Dir(Direction d) {
        mDir = d;
    }

    public Direction getDirection() {
        return mDir;
    }

    public int toInt() {
        return mDir.ordinal();
    }

    public static Direction opposite() {
        if (mDir == Direction.UNKNOW) return Direction.UNKNOW;
        return Direction.values()[(mDir.ordinal() + 2) % TOTAL_COUNT];
    }

    public Direction turnLeft() {
        if (mDir == Direction.UNKNOW) return Direction.UNKNOW;
        return Direction.values()[(mDir.ordinal() + 1) % TOTAL_COUNT];
    }

    public Direction turnRight() {
        if (mDir == Direction.UNKNOW) return Direction.UNKNOW;
        return Direction.values()[(mDir.ordinal() + 3) % TOTAL_COUNT];
    }
}
