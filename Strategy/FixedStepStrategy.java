package com.github.ryan6073.Richer.Strategy;

import com.github.ryan6073.Richer.Players.Player;

public class FixedStepStrategy extends StepStrategy {
    private int steps;

    public FixedStepStrategy(int fixedSteps) {
        steps = fixedSteps;
    }

    public void setFixedSteps(int n) {
        steps = n;
    }

    public int getFixedSteps() {
        return steps;
    }

    @Override
    public int determineSteps(Player player) {
        return steps;
    }
}

