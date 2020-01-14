package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("[레이싱게임] 을")
public class RacingGameTest {

    private RacingGame racingGame;

    @Test
    @Order(1)
    @DisplayName("생성시킨다.")
    void createTest() {

        racingGame = RacingGame.create();
        assertThat(racingGame.getClass())
                .isEqualTo(RacingGame.class);
    }

    @Test
    @Order(2)
    @DisplayName("시작시킨다.")
    void start(){

        // racingGame.start();
    }
}
