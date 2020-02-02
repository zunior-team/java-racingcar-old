package game.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("레이싱카 추적기는")
class RacingTracerTest {

    @Mock
    private RacingCar racingCar;

    @Mock
    private RacingCar firstCar;

    @Mock
    private RacingCar secondCar;

    @ParameterizedTest
    @MethodSource("provideNullOrEmptyRacingCar")
    @DisplayName("인자가 널 또는 사이즈가 0 이면 에러가 발생한다.")
    void constructorNullOrEmptyTest(final List<RacingCar> cars, final int tryCount, final String errorMessage) {

        //  when
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new RacingTracer(cars, tryCount));

        // then
        assertEquals(errorMessage, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("providePoorTryCountRacingCar")
    @DisplayName("전진횟수가 0 이면 에러가 발생한다.")
    void constructorTryCountZeroTest(final List<RacingCar> cars, final int tryCount, final String errorMessage) {

        // when
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new RacingTracer(cars, tryCount));

        // then
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    @DisplayName("레이싱 추적 내용을 반환한다.")
    void getTracesTest() {

        // given
        given(racingCar.getMyTracesByRound(1)).willReturn("붕붕 : -");
        given(racingCar.getMyTracesByRound(2)).willReturn("붕붕 : --");
        given(racingCar.getMyTracesByRound(3)).willReturn("붕붕 : ---");
        given(racingCar.getMyTracesByRound(4)).willReturn("붕붕 : ----");
        given(racingCar.getMyTracesByRound(5)).willReturn("붕붕 : -----");

        List<RacingCar> cars = new ArrayList<RacingCar>(){{add(racingCar);}};

        // when
        RacingTracer racingTracer = new RacingTracer(cars, 5);
        final String traces = racingTracer.getTraces();

        // then
        assertThat(traces).isEqualTo("붕붕 : -\n\n붕붕 : --\n\n붕붕 : ---\n\n붕붕 : ----\n\n붕붕 : -----\n\n");
    }

    @Test
    @DisplayName("레이싱 우승자를 반환한다.")
    void getWinnerTest() {

        // given
        given(firstCar.getName()).willReturn("붕붕");
        given(firstCar.getMyLastTracesLength()).willReturn(5);
        given(secondCar.getName()).willReturn("씽씽");
        given(secondCar.getMyLastTracesLength()).willReturn(5);

        List<RacingCar> cars = new ArrayList<RacingCar>(){{add(firstCar); add(secondCar);}};

        // when
        RacingTracer racingTracer = new RacingTracer(cars, 5);
        final List<String> winners = racingTracer.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
    }

    private static Stream<Arguments> provideNullOrEmptyRacingCar() {

        final String errorMessage = "레이싱 카는 널 또는 사이즈가 0 이기 때문에 추적할 수 없습니다.";

        return Stream.of(
                Arguments.of(null, 2, errorMessage),
                Arguments.of(new ArrayList<>(), 2, errorMessage)
        );
    }

    private static Stream<Arguments> providePoorTryCountRacingCar() {

        final String errorMessage = "레이싱 카의 전진횟수는 0 이기 때문에 추척할 수 없습니다.";

        return Stream.of(
            Arguments.of(new ArrayList<RacingCar>(){{add(RacingCar.createEmptyRacingCar());}}, 0, errorMessage)
        );
    }
}