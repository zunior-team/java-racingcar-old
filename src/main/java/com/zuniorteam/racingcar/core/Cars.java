package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Integer> getCurrentPositions() {
        final List<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }
}
