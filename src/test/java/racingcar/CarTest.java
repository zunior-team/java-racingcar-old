package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.history.CarSnapshot;
import racingcar.racing.Car;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void carConstructTest() {
        Car car = new Car("kwang");

        // assertThat(car.printPosition()).isEqualTo("kwang : " + DASH_MARK);
        // 생성자 테스트가 다른 함수까지 가져다 테스트를 진행하니까 리팩토링시에 문제가 생긴다.

        assertThat(car).isNotNull();
        assertThat(car.currentPosition()).isEqualTo(0);
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
        // 혹은 position만을 리턴하도록해서 다른 문제가 발생하지 않도록!
        // car.printPosition의 경우 name이 추가되면서 크지 않은 변경이 발생했음에도, 전체적인 테스트 코드의 변화가 필요했다.
        // currentPosition만을 사용하면 다른 테스트 코드가 변화될 일이 없다.
        assertThat(car.currentPosition()).isEqualTo(0);

        car.move();

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource
    void moveStrategyTest(MoveStrategy moveStrategy, int expectedPosition) {
        Car car = new Car("test", moveStrategy);

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move();

        assertThat(car.currentPosition()).isEqualTo(expectedPosition);
    }

    private static Stream moveStrategyTest() {
        return Stream.of(
                Arguments.of((MoveStrategy) () -> true, 1),
                Arguments.of((MoveStrategy) () -> false, 0)
        );
    }


    @Test
    public void checkWinnerTest() {
        Car car = new Car("test", () -> true);
        List<Car> winners = new ArrayList<>();

        assertThat(winners.size()).isEqualTo(0);

        car.move();
        car.checkWinner(winners, 1);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(car);
    }

    @Test
    public void carSnapshotTest() {
        Car car = new Car("test", () -> true);

        CarSnapshot carSnapshot = car.snapshot();

        assertThat(carSnapshot).isNotNull();
    }
}
