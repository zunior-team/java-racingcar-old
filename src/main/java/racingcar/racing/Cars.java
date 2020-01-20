package racingcar.racing;

import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> raceCandidates) {
        if(raceCandidates == null || raceCandidates.size() <= 0) {
            throw new IllegalArgumentException("Number of cars must be positive");
        }

        this.cars = raceCandidates.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(Car[] cars) {
        if(cars == null || cars.length == 0) {
            throw new IllegalArgumentException("Number of cars must be positive");
        }

        this.cars = Arrays.asList(cars);
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public String showCurrentState() {
        StringBuilder stringBuilder = new StringBuilder();

        cars.forEach(car ->
                stringBuilder.append(car.printPosition())
                        .append('\n')
        );

        return stringBuilder.toString();
    }
}
