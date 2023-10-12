package com.github.ryan6073.Richer.Rand;

import java.util.Random;
public class CRandom extends Rand {
    @Override
    public int randomValue(int low, int high) {
        if (!isInitialized) {
            initializeRandomSeed();
        }
        return random.nextInt(high - low + 1) + low;
    }

    private static Random random;
    private static boolean isInitialized = false;

    private static void initializeRandomSeed() {
        random = new Random(System.currentTimeMillis());
        isInitialized = true;
    }
}
