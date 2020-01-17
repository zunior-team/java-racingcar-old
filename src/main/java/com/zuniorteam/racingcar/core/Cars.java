package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = initCars(numberOfCars);

        validate();
    }

    private List<Car> initCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj((index) -> new Car())
                .collect(Collectors.toList());
    }

    private void validate() {
        if(this.cars.isEmpty()){
            throw new RuntimeException("자동차가 0대 입니다");
        }
    }

    public void moveAll(MovingStrategy movingStrategy){
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Integer> getCurrentPositions(){
        final List<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }
}
