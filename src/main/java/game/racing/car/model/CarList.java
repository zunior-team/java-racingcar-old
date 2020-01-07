package game.racing.car.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    List<Car> carList;

    public CarList(int capacity) {
        carList = new ArrayList<>(capacity);
    }

    public void moveAll() {
        carList.stream()
                .forEach(car -> car.move());
    }

    public List<Integer> positionAll() {
        return carList.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }
}
