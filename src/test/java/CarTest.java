import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void carConstructTest() {
        Car car = new Car();

        assertThat(car.printPosition()).isEqualTo("");
    }

    @Test
    public void moveCarTest() {
        Car car = new Car();

        assertThat(car.printPosition()).isEqualTo("");
        car.move();
        assertThat(car.printPosition()).isEqualTo(Car.DASH_MARK);
    }

    @ParameterizedTest
    @MethodSource
    public void moveStrategyTest(MoveStrategy moveStrategy, String moveFootprint) {
        Car car = new Car(moveStrategy);

        car.move();
        assertThat(car.printPosition()).isEqualTo(moveFootprint);
    }

    private static Stream moveStrategyTest() {
        return Stream.of(
                Arguments.of((MoveStrategy) () -> true, "-"),
                Arguments.of((MoveStrategy) () -> false, "")
        );
    }
}
