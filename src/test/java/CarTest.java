import org.junit.jupiter.api.Test;

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
}
