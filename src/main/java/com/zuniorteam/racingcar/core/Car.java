package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.util.StringUtils;
import com.zuniorteam.racingcar.vo.MoveHistory;

public class Car {

    private static final int START_POSITION = 0;

    private final String carName;
    private int position = START_POSITION;

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
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public MoveHistory getLastMoveHistory() {
        return new MoveHistory(carName, position);
    }

}
