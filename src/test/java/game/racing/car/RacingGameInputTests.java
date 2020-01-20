package game.racing.car;

import game.racing.car.service.RacingGame;
import game.racing.car.view.RacingGameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class RacingGameInputTests {

    @DisplayName(", 사이에 공백이 들어간 차 이름이 들어오면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource({"pobi,crong,", ",crong,honux", "pobi,,honux"})
    void abnormalCarNamesInputTest(String carNames) {
        assertThatThrownBy(() -> {
            RacingGameUtil.seprateCarNames(carNames);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("공백이외의 값들이 정상적으로 들어오는 경우")
    @ParameterizedTest
    @CsvSource({"pobi,crong,honux", "t1,t2,t3", "abc,bcd,cde"})
    void normalCarNamesInputTest(String carNames) {
        assertDoesNotThrow(() -> RacingGameUtil.seprateCarNames(carNames)));
    }

    @DisplayName("라운드 갯수가 0보다 작으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, -15 })
    void abnormalRoundCountInputTest(int roundCount) {
        assertThatThrownBy(() -> {
            new RacingGame(mock(List.class), roundCount);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("라운드 갯수가 0보다 같거나 크면 정상.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 15 })
    void normalRoundCountInputTest(int roundCount) {
        assertDoesNotThrow(() -> new RacingGame(mock(List.class), roundCount));
    }
}
