package game.racing.car.model;

import game.racing.car.model.vo.CarPosition;
import game.racing.car.service.impl.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomMovingStrategy()));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarPosition> getCarPositionAll() {
        return cars.stream()
                .map(car -> car.getCarPosition())
                .collect(Collectors.toList());
    }
}
