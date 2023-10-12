package com.github.ryan6073.Richer.Strategy;

import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Rand.Rand;

public abstract class StepStrategy {
    public static FixedStepStrategy createFixedStepStrategy(int steps) {
        return new FixedStepStrategy(steps);
    }

    public static RandomStepStrategy createRandomStepStrategy() {
        return new RandomStepStrategy();
    }

    public abstract int determineSteps(Player player);

}




