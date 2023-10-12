package com.github.ryan6073.Richer.Strategy;

import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Rand.Rand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomDirStrategy extends DirStrategy {
    @Override
    protected Dir.Direction makeDirection(Dir.Direction inDir, List<Dir.Direction> dirs) {
        Random random = new Random();
        return dirs.get(random.nextInt(dirs.size()));
    }

    @Override
    public Dir.Direction determineDirection(Player player) {
        Dir.Direction inDir = player.getImp().getEnterDir();
        List<Dir.Direction> constDirs = new ArrayList<>(player.getImp().getStand().getNeighborDirs());

        if (inDir == Dir.Direction.UNKNOW) {
            return constDirs.get(new Random().nextInt(constDirs.size()));
        }

        if (constDirs.size() == 1) {
            return inDir;
        }

        List<Dir.Direction> dirs = new ArrayList<>(constDirs);
        dirs.removeAll(Collections.singleton(inDir));

        if (dirs.size() == 1) {
            return dirs.get(0);
        }

        return makeDirection(inDir, dirs);
    }
}
