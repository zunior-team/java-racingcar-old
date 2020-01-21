package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import random.RandomGenerator;
import strategy.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("game.RacingGame 단위 테스트")
class RacingGameTest {

    private RandomMovingStrategy movingStrategy = new RandomMovingStrategy(RandomGenerator.generate());


    @Test
    @DisplayName("자동차의 이름들과, 실행할 횟수를 전하면 RacingGame을 만들 수 있다")
    void testCreate() {
        //given
        List<String> carNames = Stream.of("junwoo", "junwoochoi", "junu")
                .collect(Collectors.toList());
        int countOfTry = 5;

        //when
        RacingGame racingGame = RacingGame.newInstance(carNames, countOfTry, movingStrategy);

        //then
        assertThat(racingGame).isNotNull();
    }


    @Test
    @DisplayName("게임을 시작하면 RacingResult 객체를 반환한다")
    void testStart() {
        //given
        int numberOfCars = 3;
        int countOfTry = 5;
        RacingGame racingGame = RacingGame.newInstance(numberOfCars, countOfTry, movingStrategy);

        //when
        RacingResult racingResult = racingGame.proceedAllAndGetResult();

        //then
        assertThat(racingResult).isNotNull();
    }
}