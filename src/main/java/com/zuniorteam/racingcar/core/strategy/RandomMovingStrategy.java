package com.zuniorteam.racingcar.core.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_SIZE = 10;
    private static final int FLAG_NUMBER = 4;

    @Override
    public boolean isMoving() {
        return new Random().nextInt(RANDOM_SIZE) > FLAG_NUMBER;
    }
}
