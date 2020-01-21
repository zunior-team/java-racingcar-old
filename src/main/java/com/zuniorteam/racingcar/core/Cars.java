package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        validate(carNames);

        return carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    private void validate(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new RuntimeException("자동차가 0대 입니다");
        }
    }

    public List<MoveHistory> moveAll(MovingStrategy movingStrategy) {
        final List<MoveHistory> moveHistories = new ArrayList<>();

        for (Car car : cars) {
            moveHistories.add(car.move(movingStrategy));
        }

        return moveHistories;
    }

}
