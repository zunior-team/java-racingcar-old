package game;

import car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int countOfTurns;

    private RacingGame(int numberOfCars, int countOfTurns) {
        validate(numberOfCars, countOfTurns);

        this.countOfTurns = countOfTurns;
        cars.addAll(createCars(numberOfCars));
    }

    public static RacingGame newInstance(int numberOfCars, int countOfTry) {
        return new RacingGame(numberOfCars, countOfTry);
    }

    private List<Car> createCars(int numberOfCars) {
        return Stream.iterate(0, seed -> seed + 1)
                .limit(numberOfCars)
                .map(Car::newInstance)
                .collect(Collectors.toList());
    }

    private void validate(int numberOfCars, int countOfTry) {
        if (numberOfCars <= 0 || countOfTry <= 0) {
            throw new IllegalArgumentException("자동차 대수와 시도 횟수는 항상 0보다 커야 합니다");
        }
    }
}
