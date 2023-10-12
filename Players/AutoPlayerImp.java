package com.github.ryan6073.Richer.Players;

public class AutoPlayerImp extends PlayerImp {
    @Override
    public char flagChar(Dir.Direction d) {
        return (d == Dir.Direction.LEFT) ? '[' : ']';
    }

    @Override
    public boolean advance() {
        forceAdvance();
        return true;
    }

    @Override
    protected int decideSteps() {
        return 4;
    }
}
