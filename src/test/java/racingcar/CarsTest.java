package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
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
}
