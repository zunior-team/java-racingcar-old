package game.racing.car.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> cars;

    public CarList(int capacity) {
        cars = new ArrayList<>(capacity);
    }

    public CarList(Car... cars) {
        this.cars = Arrays.asList(cars);
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
