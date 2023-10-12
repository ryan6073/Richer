package com.github.ryan6073.Richer.Rand;

import java.util.Random;
public class Mt19937Random extends Rand {
    private static Mt19937Random instance;
    private final Random random;

    public static Mt19937Random getInstance() {
        if (instance == null) {
            instance = new Mt19937Random();
        }
        return instance;
    }

    private Mt19937Random() {
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public int randomValue(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }
}