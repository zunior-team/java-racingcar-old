package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    private static List<Car> candidates;
    private static Cars cars;

    @BeforeEach
    void init() {
        candidates = IntStream.range(0, 5)
                .mapToObj(x -> new Car(() -> true))
                .collect(Collectors.toList());

        cars = new Cars(candidates);
    }

    @Test
    public void constructorTest() {
        List<Car> candidates = IntStream.range(0, 5)
                .mapToObj(x -> new Car(() -> true))
                .collect(Collectors.toList());

        new Cars(candidates);
        new Cars(candidates.size());
    }

    @Test
    public void constructorFailTest() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(-1));
    }

    @Test
    public void moveCarsTest() {
        cars.moveCars();


        StringBuilder outputs = new StringBuilder();
        candidates.forEach(car -> outputs.append(car.printPosition()));

        assertThat(outputs.toString()).isEqualTo("-----");
    }


    @Test
    public void showCurrentStateTest() {
        assertThat(cars.showCurrentState()).isEqualTo("\n\n\n\n\n");

        String expectedString = "-\n" +
                "-\n" +
                "-\n" +
                "-\n" +
                "-\n";

        cars.moveCars();

        assertThat(cars.showCurrentState()).isEqualTo(expectedString);
    }
}
