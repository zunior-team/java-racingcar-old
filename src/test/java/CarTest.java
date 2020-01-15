import car.Car;
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
        int positionBeforeMove = car.currentPosition();
        car.move(() -> movingCondition);
        int positionAfterMove = car.currentPosition();

        //then
        assertThat(positionAfterMove - positionBeforeMove).isEqualTo(result);
    }

}