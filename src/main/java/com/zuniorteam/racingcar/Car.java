package com.zuniorteam.racingcar;

import com.sun.istack.internal.NotNull;
import com.zuniorteam.racingcar.strategy.MovingStrategy;

public class Car {

    private int position = 1;

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
