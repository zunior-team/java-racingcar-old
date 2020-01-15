package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import random.RandomGenerator;
import strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("game.RacingGame 단위 테스트")
class RacingGameTest {

    private RandomMovingStrategy movingStrategy = new RandomMovingStrategy(RandomGenerator.generate());


    @Test
    @DisplayName("자동차의 대수와, 실행할 횟수를 전하면 RacingGame을 만들 수 있다")
    void testCreate() {
        //given
        int numberOfCars = 3;
        int countOfTry = 5;

        //when
        RacingGame racingGame = RacingGame.newInstance(numberOfCars, countOfTry, movingStrategy);

        //then
        assertThat(racingGame).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"-1,1", "4, -4", "0,5", "-4,0"})
    @DisplayName("자동차의 대수와, 실행할 횟수는 음수 혹은 0 될 수 없다")
    void testValidate(int numberOfCars, int countOfTry) {


        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                //when
                () -> RacingGame.newInstance(numberOfCars, countOfTry, movingStrategy));
        assertThat(exception.getMessage()).isEqualToIgnoringCase("자동차 대수와 시도 횟수는 항상 0보다 커야 합니다");
    }

    @Test
    @DisplayName("게임을 시작하면 RacingResult 객체를 반환한다")
    void testStart() {
        //given
        int numberOfCars = 3;
        int countOfTry = 5;
        RacingGame racingGame = RacingGame.newInstance(numberOfCars, countOfTry, movingStrategy);

        //when
        RacingResult racingResult = racingGame.proceedAll();

        //then
        assertThat(racingResult).isNotNull();
    }
}