package game;

import car.Car;
import spark.utils.CollectionUtils;
import strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int countOfTurns;
    private final MovingStrategy movingStrategy;

    private RacingGame(List<String> carNames, int countOfTurns, MovingStrategy movingStrategy) {
        validate(carNames, countOfTurns);

        this.movingStrategy = movingStrategy;
        this.countOfTurns = countOfTurns;
        cars.addAll(createCars(carNames));
    }

    private void validate(List<String> carNames, int countOfTry) {
        if (countOfTry <= 0) {
            throw new IllegalArgumentException("시도 횟수는 항상 0보다 커야 합니다");
        }

        if (CollectionUtils.isEmpty(carNames)) {
            throw new IllegalArgumentException("자동차 대수는 NULL 이거나 비어있을 수 없습니다.");
        }
    }

    public static RacingGame newInstance(List<String> carNames, int countOfTurns, MovingStrategy movingStrategy) {
        return new RacingGame(carNames, countOfTurns, movingStrategy);
    }

    public RacingResult proceedAllAndGetResult() {
        RacingResult racingResult = RacingResult.newInstance();
        for (int i = 0; i < countOfTurns; i++) {
            final List<String> histories = proceedOneTurn();
            racingResult.add(histories);
        }
        return racingResult;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
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
