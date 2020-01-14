import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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


}