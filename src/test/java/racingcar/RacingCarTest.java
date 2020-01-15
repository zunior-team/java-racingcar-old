package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.DASH_MARK;

public class RacingCarTest {
    private static Car car;
    private static List<Car> candidates;
    private static Cars cars;
    private static RacingCar racingCar;

    @BeforeAll
    static void init() {
        car = new Car(() -> true);
        candidates = Arrays.asList(car);
        cars = new Cars(candidates);

        racingCar = new RacingCar(cars, 1);
    }
    @Test
    public void racingCarConstructorTest() {
        new RacingCar(cars, 10);
    }

    @ParameterizedTest
    @MethodSource
    public void constructorTest(int numberOfCar, int round) {
        assertThatThrownBy(() -> new RacingCar(numberOfCar, round)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream constructorTest() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(1, -1)
        );
    }

    @Test
    public void raceTest() {
        assertThat(car.printPosition()).isEqualTo(DASH_MARK);

        racingCar.race();

        assertThat(car.printPosition()).isEqualTo(DASH_MARK + DASH_MARK);
    }

    @Test
    public void showRacingResultTest() {
        List<Car> candidates = IntStream.range(0, 10)
                .mapToObj(x -> new Car(() -> x % 2 == 0))
                .collect(Collectors.toList());

        RacingCar racingCar = new RacingCar(new Cars(candidates), 2);

        assertThat(racingCar.showCurrentState()).isEqualTo(
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n" +
                        "-\n"
        );

        racingCar.race();

        assertThat(racingCar.showCurrentState()).isEqualTo(
                        "---\n" +
                        "-\n" +
                        "---\n" +
                        "-\n" +
                        "---\n" +
                        "-\n" +
                        "---\n" +
                        "-\n" +
                        "---\n" +
                        "-\n"
        );
    }

    @Test
    public void getRacingHistoryTest() {
        List<Car> candidates = IntStream.range(0, 1)
                .mapToObj(x -> new Car(() -> x % 2 == 0))
                .collect(Collectors.toList());

        RacingCar racingCar = new RacingCar(new Cars(candidates), 3);

        assertThat(racingCar.getRaceHistory()).isEqualTo(
                        "-\n" +
                        "-\n"
        );

        racingCar.race();

        assertThat(racingCar.showCurrentState()).isEqualTo(
                        "-\n" +
                        "-\n\n" +
                        "--\n" +
                        "-\n\n" +
                        "---\n" +
                        "-\n\n"
        );
    }
}
