package racingcar.racing;

import racingcar.dto.RacingCarInput;
import racingcar.dto.RacingResult;
import racingcar.history.RacingHistory;

import java.util.List;

public class Racing {
    private Cars cars;
    private RacingHistory racingHistory;
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
        this.racingHistory = new RacingHistory();

        racingHistory.recordRoundHistory(cars.recordRoundHistory());
    }

    public void race() {
        for( ; currentRound < round ; ++currentRound) {
            cars.moveCars();

            racingHistory.recordRoundHistory(cars.recordRoundHistory());
        }
    }

    public RacingResult result() {
        return new RacingResult(racingHistory.showRacingHistory(), cars.getWinners());
    }

}
