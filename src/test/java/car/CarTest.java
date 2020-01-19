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
    @DisplayName("car는 자신이 지나온 길을 String타입의 Track로 보여준다")
    @CsvSource({"4, |----", "2,|--", "0,|"})
    void testTrack(int countOfMove, String expectedTrack) {
        //given
        Car car = Car.newInstance(1);
        for (int i = 0; i < countOfMove; i++) {
            car.move(() -> true);
        }

        //when
        final String track = car.getTrack();

        //then
        assertThat(track).isEqualTo(expectedTrack);
    }


    @ParameterizedTest
    @DisplayName("car.Car 는 주어진 조건이 true일 때 이동한다")
    //given
    @CsvSource({"true,1", "false,0"})
    void testMove(boolean movingCondition, int result) {
        //when
        Car car = Car.newInstance(1);
        String trackBeforeMove = car.getTrack();
        car.move(() -> movingCondition);
        String trackAfterMove = car.getTrack();

        //then
        assertThat(trackAfterMove.length() - trackBeforeMove.length()).isEqualTo(result);
    }


}