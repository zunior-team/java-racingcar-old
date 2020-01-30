package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.util.StringUtils;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;
    private final String carName;

    public Car(String carName) {
        validate(carName);

        this.carName = carName;
    }

    private void validate(String carName) {
        if (StringUtils.isEmpty(carName)) {
            throw new RuntimeException("자동차 이름이 없습니다");
        }
    }

    public void move(MovingStrategy movingStrategy) {
        validateMove(movingStrategy);

        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    private void validateMove(MovingStrategy movingStrategy) {
        if(Objects.isNull(movingStrategy)){
            throw new RuntimeException("자동차 이동 전략이 null 입니다");
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }


}
