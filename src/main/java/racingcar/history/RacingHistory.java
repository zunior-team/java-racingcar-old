package racingcar.history;

import java.util.ArrayList;
import java.util.List;

public class RacingHistory {
    private List<RoundHistory> roundHistories = new ArrayList<>();

    public void recordRoundHistory(RoundHistory roundHistory) {
        roundHistories.add(roundHistory);
    }

    public String showRacingHistory() {
        StringBuilder racingHistory = new StringBuilder();

        for(RoundHistory roundHistory : roundHistories) {
            racingHistory.append(roundHistory.showRoundHistory())
                    .append('\n');
        }

        return racingHistory.toString();
    }

    /*
        test 만을 위해 존재하는 메소드는 좋을까?
        이 메소드 말고 recordRoundHistory에서 add 이후의 사이즈를 반환하는 것은 어떨까?
     */
    public int roundCount() {
        return roundHistories.size();
    }
}
