package racingcar.dto;

import java.util.List;

public class RacingCarInput {
    private List<String> raceCandidates;
    private int numberOfRound;

    public RacingCarInput(List<String> raceCandidates, int numberOfRound) {
        this.raceCandidates = raceCandidates;
        this.numberOfRound = numberOfRound;
    }

    public List<String> getRaceCandidates() {
        return raceCandidates;
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
