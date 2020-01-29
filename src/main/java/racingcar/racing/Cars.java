package racingcar.racing;

import racingcar.history.RoundHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public RoundHistory recordRoundHistory() {
        return new RoundHistory(
                cars.stream()
                .map(Car::snapshot)
                .collect(Collectors.toList())
        );
    }

    public int getLeaderPosition() {

        return cars.stream()
                .mapToInt(Car::currentPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int winnerPosition = getLeaderPosition();
        List<Car> winners = new ArrayList<>();

        cars.forEach(car -> car.checkWinner(winners, winnerPosition));

        return winners;
    }
}
