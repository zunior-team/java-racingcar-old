package racingcar.roundHistory;

import org.junit.jupiter.api.Test;
import racingcar.history.CarSnapshot;
import racingcar.history.RoundHistory;
import racingcar.racing.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundHistoryTest {
    @Test
    public void roundHistoryTest() {
        Car car1 = new Car("car1", () -> true);
        Car car2 = new Car("car2", () -> true);

        List<CarSnapshot> carSnapshots = Arrays.asList(car1.snapshot(), car2.snapshot());

        RoundHistory roundHistory = new RoundHistory(carSnapshots);

        assertThat(roundHistory).isNotNull();
    }
}
