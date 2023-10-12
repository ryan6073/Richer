package com.github.ryan6073.Richer.Players;

public class UserPlayer extends PlayerImp {
    @Override
    public char flagChar(Dir.Direction d) {
        return (d == Dir.Direction.LEFT) ? '(' : ')';
    }

    @Override
    public boolean advance() {
        return super.advance();
    }

    @Override
    protected int decideSteps() {
        return 3;
    }
}
