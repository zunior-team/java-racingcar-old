package com.zuniorteam.racingcar.core.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_SIZE = 10;
    private static final int FLAG_NUMBER = 4;
    private final Random random;

    public RandomMovingStrategy() {
        this(new Random());
    }

    public RandomMovingStrategy(Random random) {
        assert random != null;

        this.random = random;
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_SIZE) >= FLAG_NUMBER;
    }
}
