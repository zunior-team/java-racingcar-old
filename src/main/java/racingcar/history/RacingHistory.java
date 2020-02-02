package racingcar.history;

import java.util.ArrayList;
import java.util.List;

public class RacingHistory {
    private List<RoundHistory> roundHistories = new ArrayList<>();

    public void recordRoundHistory(RoundHistory roundHistory) {
        roundHistories.add(roundHistory);
    }

    public List<RoundHistory> getRoundHistories() {
        return roundHistories;
    }
}
