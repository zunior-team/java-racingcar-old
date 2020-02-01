package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("레이싱 카들은")
class RacingCarTest {

    @Mock
    private MovementStrategy movementStrategy;

    @ParameterizedTest(name = "랜덤 {0} 반환, {1} 회 수행, {2} 의 결과 : {3} ")
    @CsvSource({
            "5, 5, 붕붕, 붕붕 : -----",
            "6, 5, 씽씽, 씽씽 : -----",
            "7, 5, 하하, 하하 : -----",
            "8, 5, 줌줌, 줌줌 : -----",
            "9, 5, 고고, 고고 : -----",
            "4, 5, 긱긱, 긱긱 : -----",
            "3, 5, 희희, 희희 :",
            "2, 5, 푸푸, 푸푸 :",
            "1, 5, 루루, 루루 :",
})
    @DisplayName("이동을 하거나 이동을 하지 못한다.")
    void moveTest(final int strategyNumber, final int tryCount, final String name, final String expectRoad) {

        // given
        given(movementStrategy.getNumberByStrategy()).willReturn(strategyNumber);

        final RacingCar racingCar = new RacingCar(tryCount, name, movementStrategy);

        // when
        racingCar.move();
        final String traces = racingCar.getMyTracesByRound(tryCount);

        // then
        if(strategyNumber <= 3) {
            assertThat(traces).isEqualTo(expectRoad + " ");
        } else {
            assertThat(traces).isEqualTo(expectRoad);
        }
    }
}