package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.racing.Car;
import racingcar.racing.Cars;
import racingcar.racing.Racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.racing.Car.DASH_MARK;

public class RacingTest {
    private static Car car;
    private static Car[] candidates;
    private static Cars cars;
    private static Racing racing;

    @BeforeAll
    static void init() {
        car = new Car("", () -> true);
        candidates = new Car[]{car};

        cars = new Cars(candidates);

        racing = new Racing(cars, 1);
    }

    @Test
    void racingCarConstructorTest() {
        assertThat(new Racing(cars, 10)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    void constructorTest(List<String> candidates, int round) {
        assertThatThrownBy(() -> new Racing(candidates, round)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream constructorTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(), 1),
                Arguments.of(Arrays.asList("nokchax"), -1)
        );
    }

    @Test
    void raceTest() {
        assertThat(car.currentPosition()).isEqualTo(0);

        racing.race();

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    void showRacingResultTest() {
        List<Car> candidates = IntStream.range(0, 10)
                .mapToObj(x -> new Car("", () -> x % 2 == 0))
                .collect(Collectors.toList());

        Racing racing = new Racing(new Cars(candidates.toArray(new Car[]{})), 2);

        assertThat(racing.showCurrentState()).isEqualTo(
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n" +
                        " : -\n"
        );

        racing.race();

        assertThat(racing.showCurrentState()).isEqualTo(
                        " : ---\n" +
                        " : -\n" +
                        " : ---\n" +
                        " : -\n" +
                        " : ---\n" +
                        " : -\n" +
                        " : ---\n" +
                        " : -\n" +
                        " : ---\n" +
                        " : -\n"
        );
    }

    @Test
    void getRacingHistoryTest() {
        List<Car> candidates = IntStream.range(0, 2)
                .mapToObj(x -> new Car("", () -> x % 2 == 0))
                .collect(Collectors.toList());

        Racing racing = new Racing(new Cars(candidates.toArray(new Car[]{})), 2);

        assertThat(racing.showCurrentState()).isEqualTo(
                        " : -\n" +
                        " : -\n"
        );

        racing.race();

        assertThat(racing.result().getRaceHistory()).isEqualTo(
                        " : -\n" +
                        " : -\n\n" +
                        " : --\n" +
                        " : -\n\n" +
                        " : ---\n" +
                        " : -\n\n"
        );
    }
}
