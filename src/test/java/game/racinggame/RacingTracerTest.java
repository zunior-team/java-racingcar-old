package game.racinggame;

import game.racinggame.dto.RacingCreateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("레이싱카 추적기는")
class RacingTracerTest {

    @ParameterizedTest
    @MethodSource("providePoorRacingCar")
    @DisplayName("인자가 널 또는 사이즈가 0 이면 에러가 발생한다.")
    public void constructErrorTest(final List<RacingCar> cars, final int tryCount, final String errorMessage) {

        // given & when
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new RacingTracer(cars, tryCount));

        assertEquals(errorMessage, exception.getMessage());
    }

    private static Stream<Arguments> providePoorRacingCar() {

        final String errorMessage = "레이싱 카는 널 또는 사이즈가 0 이기 때문에 추적할 수 없습니다.";

        return Stream.of(
                Arguments.of(null, 2, errorMessage),
                Arguments.of(new ArrayList<>(), 2, errorMessage)
        );
    }
}