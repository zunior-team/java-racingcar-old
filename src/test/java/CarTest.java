import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 객체 단위 테스트")
class CarTest {

    @Test
    @DisplayName("Car 객체를 생성한다.")
    void createCarTest() {
        //when
        Car car = Car.newInstance();

        //then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("Car 는 주어진 조건이 true일 때 이동한다")
    //given
    @CsvSource({"true,1", "false,0"})
    void testMove(boolean movingCondition, int result) {
        //when
        Car car = Car.newInstance();
        int positionBeforeMove = car.currentPositon();
        car.move(() -> movingCondition);
        int positionAfterMove = car.currentPositon();

        //then
        assertThat(positionAfterMove - positionBeforeMove).isEqualTo(result);
    }

}