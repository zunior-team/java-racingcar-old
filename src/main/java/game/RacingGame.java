package game;

import car.Car;
import spark.utils.CollectionUtils;
import strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String NEXT_LINE = "\n";
    private final List<Car> cars = new ArrayList<>();
    private final MovingStrategy movingStrategy;
    private final List<Car> winners = new ArrayList<>();
    private int countOfTurns;

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

    public boolean isDone() {
        return this.countOfTurns == 0;
    }

    public List<String> proceedAndGetTrack() {
        proceedOneTurn();
        return cars.stream()
                .map(Car::getTrack)
                .collect(Collectors.toList());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::newInstance)
                .collect(Collectors.toList());
    }

    private void proceedOneTurn() {
        validateLeftTurnCounts();
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        this.countOfTurns--;

        if (countOfTurns == 0) {
            final int max = findMaxPosition();
            cars.stream()
                    .filter(car -> car.getPosition() == max)
                    .forEach(winners::add);
        }
    }

    private void validateLeftTurnCounts() {
        if (countOfTurns < 1) {
            throw new IllegalArgumentException("모든 턴을 플레이했습니다.");
        }
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }


    public List<Car> getWinner() {
        return winners;
    }
}
