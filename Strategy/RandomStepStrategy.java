package com.github.ryan6073.Richer.Strategy;

import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Rand.Rand;


public class RandomStepStrategy extends StepStrategy {
    @Override
    public int determineSteps(Player player) {
        return Rand.byRange(1, 6);
    }
}