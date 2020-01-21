package game.racing.car;

import game.racing.car.model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTests {

    @DisplayName("우승자 테스트")
    @ParameterizedTest
    @MethodSource
    void racingWinnerTest(List<String> carNames, List<Integer> positions, List<String> expectedWinners) {
        Cars cars = new Cars(carNames.toArray(), positions);
        assertThat(cars.getWinnerNames()).isEqualTo(expectedWinners);
    }

    private static Stream racingWinnerTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), Arrays.asList(3, 6, 5), Arrays.asList("crong")),
                Arguments.of(Arrays.asList("paul1", "paul2", "paul3"), Arrays.asList(0, 2, 3), Arrays.asList("paul3")),
                Arguments.of(Arrays.asList("abc", "bcd", "cde"), Arrays.asList(1, 2, 3), Arrays.asList("cde")),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), Arrays.asList(1, 2, 2), Arrays.asList("crong", "honux")),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), Arrays.asList(0, 0, 0), Arrays.asList("pobi", "crong", "honux"))
        );
    }
}
