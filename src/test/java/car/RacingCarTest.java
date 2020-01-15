package car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱 카는")
public class RacingCarTest {


    private RacingCar racingCar;

    @BeforeAll
    public void setup() {
        racingCar = new RacingCar();
    }

    @Test
    @DisplayName(value = "이동을 수행한다.")
    void moveTest() {
        racingCar.move();
    }


}
