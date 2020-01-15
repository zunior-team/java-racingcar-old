package com.zuniorteam.racingcar.core;

import com.sun.istack.internal.NotNull;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;

    private Car() {
    }

    public static Car newInstance() {
        return new Car();
    }

    public int move(@NotNull MovingStrategy movingStrategy) {
        assert movingStrategy != null;

        if (movingStrategy.isMoving()) {
            position++;
        }

        return position;
    }

}
