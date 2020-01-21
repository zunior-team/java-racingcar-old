package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.racing.Car;
import racingcar.racing.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    private static List<String> candidates;
    private static Car[] carCandidate;
    private static Cars cars;

    @BeforeEach
    void init() {
        candidates = Arrays.asList("nokcha", "nokchax", "nokchaxx");
        carCandidate = new Car[]{
                new Car("nokcha", () -> true),
                new Car("nokchax", () -> true),
                new Car("nokchaxx", () -> true)
        };

        cars = new Cars(carCandidate);
    }

    @Test
    void constructorTest() {
        // 이정도로 충분할까?
        assertThat(new Cars(candidates)).isNotNull();
    }

    @Test
    void constructorFailTest() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(Arrays.asList()));
    }

    @Test
    void moveCarsTest() {
        cars.moveCars();

        Arrays.stream(carCandidate)
                .forEach(car -> {
                    assertThat(car.currentPosition()).isEqualTo(1);
                });
    }


    @Test
    void showCurrentStateTest() {
        assertThat(cars.showCurrentState()).isEqualTo("nokcha : -\nnokchax : -\nnokchaxx : -\n");

        String expectedString = "nokcha : --\n" +
                "nokchax : --\n" +
                "nokchaxx : --\n";

        cars.moveCars();

        assertThat(cars.showCurrentState()).isEqualTo(expectedString);
    }
}
