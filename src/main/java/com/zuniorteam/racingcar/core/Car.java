package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position++;
        }

        return position;
    }

}
