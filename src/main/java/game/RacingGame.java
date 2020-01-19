package game;

import car.Car;
import strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int countOfTurns;
    private final MovingStrategy movingStrategy;

    private RacingGame(int numberOfCars, int countOfTurns, MovingStrategy movingStrategy) {
        validate(numberOfCars, countOfTurns);

        this.movingStrategy = movingStrategy;
        this.countOfTurns = countOfTurns;
        cars.addAll(createCars(numberOfCars));
    }

    private void validate(int numberOfCars, int countOfTry) {
        if (numberOfCars <= 0 || countOfTry <= 0) {
            throw new IllegalArgumentException("자동차 대수와 시도 횟수는 항상 0보다 커야 합니다");
        }
    }

    public static RacingGame newInstance(int numberOfCars, int countOfTurns, MovingStrategy movingStrategy) {
        return new RacingGame(numberOfCars, countOfTurns, movingStrategy);
    }

    public RacingResult proceedAllAndGetResult() {
        RacingResult racingResult = RacingResult.newInstance();
        for (int i = 0; i < countOfTurns; i++) {
            final List<String> histories = proceedOneTurn();
            racingResult.add(histories);
        }
        return racingResult;
    }

    private List<Car> createCars(int numberOfCars) {
        return Stream.iterate(0, seed -> seed + 1)
                .limit(numberOfCars)
                .map(Car::newInstance)
                .collect(Collectors.toList());
    }

    private List<String> proceedOneTurn() {
        return cars.stream()
                .map(car -> {
                    car.move(movingStrategy);
                    return car.getTrack();
                })
                .collect(Collectors.toList());
    }
}
