package game.racing.car;

import game.racing.car.model.Car;
import game.racing.car.model.Cars;
import game.racing.car.service.MovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class RacingGameTests {

    @DisplayName("우승자 테스트")
    @ParameterizedTest
    @MethodSource
    void racingWinnerTest(List<String> carNames, List<Integer> positions, List<String> expectedWinners) {
        Cars cars = new Cars(makeCars(carNames, positions));
        assertThat(cars.getWinnerNames()).isEqualTo(expectedWinners);
    }

    private List<Car> makeCars(List<String> carNames, List<Integer> positions) {
        return IntStream.rangeClosed(0, carNames.size())
                .mapToObj(i -> new Car(carNames.get(i), positions.get(i), mock(MovingStrategy.class)))
                .collect(Collectors.toList());
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
