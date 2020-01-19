package game.racing.car;

import game.racing.car.service.RacingGame;
import game.racing.car.view.RacingGameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

@DisplayName("차 갯수 혹은 라운드 갯수가 0보다 작으면 에러가 발생한다.")
@ExtendWith(MockitoExtension.class)
public class RacingGameInputTests {

    @DisplayName("두 변수 중 하나라도 0보다 작을 때")
    @ParameterizedTest
    @CsvSource({"0,-1", "-2,5", "-3,-6"})
    void abnormalInputTest(int carCount, int roundCount) {
        assertThatThrownBy(() -> {
            new RacingGame(carCount, roundCount, mock(RacingGameView.class));
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("두 변수가 둘 다 0보다 같거나 클떄")
    @ParameterizedTest
    @CsvSource({"0,0", "2,5", "3,12"})
    void normalInputTest(int carCount, int roundCount) {
        assertDoesNotThrow(() -> new RacingGame(carCount, roundCount, mock(RacingGameView.class)));
    }
}
