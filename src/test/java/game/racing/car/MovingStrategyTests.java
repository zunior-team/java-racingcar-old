package game.racing.car;

import game.racing.car.model.Car;
import game.racing.car.service.MovingStrategy;
import game.racing.car.service.impl.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MovingStrategyTests {
    @Mock
    private Random random;

    @DisplayName("랜덤 값이 4 이상이면 True를 리턴, 4보다 작으면 False를 리턴한다.")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    @ExtendWith(MockitoExtension.class)
    void randomMovingStrategyTest(int randomNumber, boolean expectedPosition) {
        when(random.nextInt(anyInt())).thenReturn(randomNumber);

        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        assertThat(movingStrategy.isMovable()).isEqualTo(expectedPosition);
    }
}
