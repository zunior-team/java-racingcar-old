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

    public void move(@NotNull MovingStrategy movingStrategy) {
        assert movingStrategy != null;

        if (movingStrategy.isMoving()) {
            position++;
        }
    }

    public String printPosition() {
        final StringBuilder print = new StringBuilder();

        for(int i =0; i < position; i++){
            print.append("-");
        }

        return print.toString();
    }
}
