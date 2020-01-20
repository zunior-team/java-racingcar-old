package racingcar.dto;

import java.util.List;

public class RacingResult {
    private String raceHistory;
    private List<String> winners;

    public RacingResult(String raceHistory, List<String> winners) {
        this.raceHistory = raceHistory;
        this.winners = winners;
    }

    public String getRaceHistory() {
        return raceHistory;
    }
}
