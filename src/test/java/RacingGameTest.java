import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 단위 테스트")
class RacingGameTest {

    @Test
    @DisplayName("자동차의 대수와, 실행할 횟수를 전하면 RacingGame을 만들 수 있다")
    void testCreate() {
        //given
        int numberOfCars = 3;
        int countOfTry = 5;

        //when
        RacingGame racingGame = RacingGame.newInstance(numberOfCars, countOfTry);

        //then
        assertThat(racingGame).isNotNull();
    }

}