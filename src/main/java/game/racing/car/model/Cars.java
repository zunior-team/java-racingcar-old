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

    public List<CarPosition> getPositionAll() {
        return cars.stream()
                .map(car -> car.makeCarPosition())
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {

        Integer winnerScore = cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElseThrow(() -> new RuntimeException("Unexpected Error."));

        return cars.stream()
                .filter(car -> winnerScore.equals(car.getPosition()))
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }
}
