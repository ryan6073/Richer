package com.github.ryan6073.Richer.Players;

import java.util.Random;
import java.util.ArrayList;

import com.github.ryan6073.Richer.Blocks.Block;
import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Players.Dir.Direction;
import com.github.ryan6073.Richer.Strategy.DirStrategy;
import com.github.ryan6073.Richer.Strategy.StepStrategy;

public class Player implements IPlayer {

    private PlayerImp imp;
    private DirStrategy dirStrategy;
    private StepStrategy stepStrategy;

    public Player() {
        imp = new PlayerImp();
    }

    public boolean advance() {
        return imp.advance();
    }

    public void forceAdvance() {
        imp.forceAdvance();
    }

    public char flagChar(Dir.Direction d) {
        return imp.flagChar(d);
    }

    protected int decideSteps() {
        return imp.decideSteps();
    }

    protected boolean moveStep() {
        return imp.moveStep();
    }

    protected Dir.Direction decideMoveDir() {
        return imp.decideMoveDir();
    }
    public void setImp(PlayerImp pImp) {
        imp = pImp;
        imp.setPlayer(this);
    }

    public PlayerImp getImp() {
        return imp;
    }

    public PlayerImp operator() {
        return imp;
    }

    public DirStrategy getDirStrategy() {
        return dirStrategy;
    }

    public void setDirStrategy(DirStrategy strategy) {
        dirStrategy = strategy;
    }

    public StepStrategy getStepStrategy() {
        return stepStrategy;
    }

    public void setStepStrategy(StepStrategy strategy) {
        stepStrategy = strategy;
    }
}

