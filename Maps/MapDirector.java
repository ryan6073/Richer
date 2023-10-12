package com.github.ryan6073.Richer.Maps;

public class MapDirector {
    protected MapBuilder mpBuilder;

    public MapDirector(MapBuilder builder) {
        mpBuilder = builder;
    }

    public Map makeMap() {
        return null; // Implement in derived classes
    }
}

