package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Car.DASH_MARK;

public class racingCarTest {
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
}
