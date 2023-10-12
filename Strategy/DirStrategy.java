package com.github.ryan6073.Richer.Strategy;
import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Rand.Rand;
import com.github.ryan6073.Richer.Players.Dir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class DirStrategy {
    public abstract Dir.Direction determineDirection(Player player);

    protected Dir.Direction makeDirection(Dir.Direction inDir, List<Dir.Direction> dirs) {
        return null; // To be implemented by subclasses
    }
}

