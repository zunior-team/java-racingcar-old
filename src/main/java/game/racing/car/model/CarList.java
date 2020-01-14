package game.racing.car.model;

import game.racing.car.service.impl.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> cars;

    public CarList(int capacity) {
        cars = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            cars.add(new Car(new RandomMovingStrategy()));
        }
    }

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        cars.stream()
                .forEach(car -> car.move());
    }

    public List<Integer> positionAll() {
        return cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }
}
