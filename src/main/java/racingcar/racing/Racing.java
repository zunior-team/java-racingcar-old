package racingcar.racing;

import racingcar.dto.RacingCarInput;
import racingcar.dto.RacingResult;

import java.util.List;

public class Racing {
    private Cars cars;
    private StringBuilder raceHistory;
    private int round;
    private int currentRound;

    public Racing(RacingCarInput racingCarInput) {
        this(racingCarInput.getRaceCandidates(), racingCarInput.getNumberOfRound());
    }

    public Racing(List<String> raceCandidates, int round) {
        this(new Cars(raceCandidates), round);
    }

    public Racing(Cars cars, int round) {
        if(round < 0) {
            throw new IllegalArgumentException("Round must be greater than 0");
        }

        this.cars = cars;
        this.round = round;
        this.currentRound = 0;
        this.raceHistory = new StringBuilder();
        registerHistory(cars.showCurrentState());
    }

    public void race() {
        for( ; currentRound < round ; ++currentRound) {
            cars.moveCars();

            registerHistory(cars.showCurrentState());
        }
    }

    private void registerHistory(String state) {
        raceHistory.append(state)
                .append('\n');
    }

    public String showCurrentState() {
        return cars.showCurrentState();
    }

    public RacingResult result() {
        return new RacingResult(raceHistory.toString(), cars.getWinners());
    }

}
