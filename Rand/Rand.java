package com.github.ryan6073.Richer.Rand;

public abstract class Rand {
    public static int byRange(int low, int high) {
        return getRandomInstance().randomValue(low, high);
    }

    public abstract int randomValue(int low, int high);

    private static Rand getRandomInstance() {
        // Use Mt19937Random as the default random generator
        return Mt19937Random.getInstance();
    }
}
