package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("car.Car 객체 단위 테스트")
class CarTest {

    @Test
    @DisplayName("car.Car 객체를 생성한다.")
    void createCarTest() {
        //when
        Car car = Car.newInstance(0);

        //then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("car.Car 는 주어진 조건이 true일 때 이동한다")
    //given
    @CsvSource({"true,1", "false,0"})
    void testMove(boolean movingCondition, int result) {
        //when
        Car car = Car.newInstance(1);
        String historyBeforeMove = car.getHistory();
        car.move(() -> movingCondition);
        String historyAfterMove = car.getHistory();

        //then
        assertThat(historyAfterMove.length() - historyBeforeMove.length()).isEqualTo(result);
    }

}