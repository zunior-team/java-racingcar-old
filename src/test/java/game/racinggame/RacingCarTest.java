package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("레이싱 카들은")
class RacingCarTest {

    @Mock
    private MovementStrategy movementStrategy;

    @ParameterizedTest(name = "랜덤값 {0} 을 반환, {1} 회 수행, {2} 이동 ")
    @CsvSource({
            "5, 5, -----",
            "6, 5, -----",
            "7, 5, -----",
            "8, 5, -----",
            "9, 5, -----",
            "4, 5, -----",
            "3, 5, ''",
            "2, 5, ''",
            "1, 5, ''",
    })
    @DisplayName("이동을 하거나 이동을 하지 못한다.")
    void moveTest(final int strategyNumber, final int tryCount, final String expectRoad) {

        // given
        given(movementStrategy.getNumberByStrategy()).willReturn(strategyNumber);

        final RacingCar racingCar = new RacingCar(tryCount);
        racingCar.updateStrategy(movementStrategy);

        // when
        racingCar.move();
        final List<String> traced = racingCar.getTraces();

        // then
        assertThat(traced.get(5)).isEqualTo(expectRoad);
    }
}