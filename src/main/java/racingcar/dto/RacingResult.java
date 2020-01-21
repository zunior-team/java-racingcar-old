package racingcar.dto;

import racingcar.racing.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private String raceHistory;
    private List<Car> winners;

    public RacingResult(String raceHistory, List<Car> winners) {
        this.raceHistory = raceHistory;
        this.winners = winners;
    }

    public String getRaceHistory() {
        return raceHistory;
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
