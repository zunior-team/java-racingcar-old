package racingcar.history;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingHistoryTest {

    @Test
    public void RacingHistoryTest() {
        RacingHistory racingHistory = new RacingHistory();

        assertThat(racingHistory).isNotNull();
    }

    @Test
    public void recordRoundHistoryTest() {
        RoundHistory roundHistory = new RoundHistory(Arrays.asList(
                new CarSnapshot("car1", 0),
                new CarSnapshot("car2", 0)
        ));

        RacingHistory racingHistory = new RacingHistory();

        assertThat(racingHistory.roundCount()).isEqualTo(0);
        racingHistory.recordRoundHistory(roundHistory);
        assertThat(racingHistory.roundCount()).isEqualTo(1);
    }
}
