package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.racing.Car;
import racingcar.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void carConstructTest() {
        Car car = new Car("kwang");

        // assertThat(car.printPosition()).isEqualTo("kwang : " + DASH_MARK);
        // 생성자 테스트가 다른 함수까지 가져다 테스트를 진행하니까 리팩토링시에 문제가 생긴다.

        assertThat(car).isNotNull();
    }

    @Test
    void moveCarTest() {
        Car car = new Car("kwang", () -> true);

/*
        assertThat(car.printPosition()).isEqualTo(DASH_MARK);
        car.move();
        assertThat(car.printPosition()).isEqualTo(DASH_MARK + DASH_MARK);

*/
        // 여기도 마찬가지.. car.move()만으로 테스트 할 수 있도록 변경해야한다.
        int nextPosition = car.move();
        assertThat(nextPosition).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource
    void moveStrategyTest(MoveStrategy moveStrategy, int moveFootprint) {
        Car car = new Car("test", moveStrategy);

        int position = car.move();
        assertThat(position).isEqualTo(moveFootprint);
    }

    private static Stream moveStrategyTest() {
        return Stream.of(
                Arguments.of((MoveStrategy) () -> true, 1),
                Arguments.of((MoveStrategy) () -> false, 0)
        );
    }
}
