package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.racing.Car;
import racingcar.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.racing.Car.DASH_MARK;

public class CarTest {

    @Test
    void carConstructTest() {
        Car car = new Car();

        assertThat(car.printPosition()).isEqualTo(DASH_MARK);
    }

    @Test
    void moveCarTest() {
        Car car = new Car(() -> true);

        assertThat(car.printPosition()).isEqualTo(DASH_MARK);
        car.move();
        assertThat(car.printPosition()).isEqualTo(DASH_MARK + DASH_MARK);
    }

    @ParameterizedTest
    @MethodSource
    void moveStrategyTest(MoveStrategy moveStrategy, String moveFootprint) {
        Car car = new Car(moveStrategy);

        car.move();
        assertThat(car.printPosition()).isEqualTo(moveFootprint);
    }

    private static Stream moveStrategyTest() {
        return Stream.of(
                Arguments.of((MoveStrategy) () -> true, DASH_MARK + DASH_MARK),
                Arguments.of((MoveStrategy) () -> false, DASH_MARK)
        );
    }
}
