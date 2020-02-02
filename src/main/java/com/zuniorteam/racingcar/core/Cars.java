package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        assert carNames != null : "CarNames is Null!";

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

    public List<MoveHistory> getLastMoveHistories() {
        return cars.stream()
                .map(car -> new MoveHistory(car.getCarName(), car.getPosition()))
                .collect(toList());
    }

    public List<String> getNamesOfCarAtTopPosition() {
        final Integer topPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition).orElse(0);

        return cars.stream()
                .filter(car -> topPosition.equals(car.getPosition()))
                .map(Car::getCarName)
                .collect(toList());
    }
}
