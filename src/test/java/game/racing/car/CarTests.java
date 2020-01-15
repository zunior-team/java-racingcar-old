package game.racing.car;

import game.racing.car.model.Car;
import game.racing.car.model.Cars;
import game.racing.car.service.MovingStrategy;
import game.racing.car.service.impl.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTests {

    @Mock
    private Random random;

    @DisplayName("랜덤 값이 4 이상이면 움직이고, 4보다 작으면 움직이지 않는다.")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @ExtendWith(MockitoExtension.class)
    void carRandomMovingTest(int randomNumber, int expectedPosition) {
        when(random.nextInt(anyInt())).thenReturn(randomNumber);
        Car car = createCarWithRandomMovingStrategy();
        car.move();
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName(value = "차 리스트 이동 테스트")
    @ParameterizedTest
    @MethodSource
    @ExtendWith(MockitoExtension.class)
    void carListMovingTests(List<Integer> initPosition, List<Integer> randomNumbers, List<Integer> result) {
        Cars cars = new Cars(createCarList(initPosition, randomNumbers));
        cars.moveAll();
        assertThat(cars.positionAll()).isEqualTo(result);
    }

    private List<Car> createCarList(List<Integer> initPosition, List<Integer> randomNumbers) {
        return IntStream.range(0, initPosition.size())
                .mapToObj(i -> createCar(initPosition.get(i), randomNumbers.get(i)))
                .collect(Collectors.toList());
    }

    private Car createCarWithRandomMovingStrategy() {
        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        return new Car(movingStrategy);
    }

    private Car createCar(Integer initPosition, Integer randomNumber) {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(randomNumber);
        MovingStrategy movingStrategy = new RandomMovingStrategy(mockRandom);
        return new Car(initPosition, movingStrategy);
    }

    private static Stream carListMovingTests() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2), Arrays.asList(4, 1, 2), Arrays.asList(1, 1, 2)),
                Arguments.of(Arrays.asList(0, 0, 0), Arrays.asList(4, 8, 9), Arrays.asList(1, 1, 1)),
                Arguments.of(Arrays.asList(3, 1, 5), Arrays.asList(3, 6, 2), Arrays.asList(3, 2, 5))
        );
    }
}