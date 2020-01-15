package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.core.vo.GameResult;
import com.zuniorteam.racingcar.core.vo.StepResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RacingGameTest {

    @DisplayName("생성 테스트")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new RacingGame(1, 1));
    }

    @DisplayName("생성 테스트, 차가 0대이거나, 횟수가 0 일때")
    @ParameterizedTest(name = "자동차 : {0}, 횟수 : {1}")
    @CsvSource({
            "0, 0",
            "0, 1",
            "1, 0",
    })
    void testNewInstance02(int numberOfCars, int numberOfStep) {
        assertThrows(RuntimeException.class, () -> new RacingGame(numberOfCars, numberOfStep));
    }

    @DisplayName("DoGame 테스트")
    @Test
    void testDoGame01() {
        //given
        final int numberOfCars = 1;
        final int numberOfStep = 1;

        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);

        final MovingStrategy mockMovingStrategy = Mockito.mock(MovingStrategy.class);
        given(mockMovingStrategy.isMoving()).willReturn(true);

        //when, then
        assertDoesNotThrow(() -> racingGame.doGame(mockMovingStrategy));
    }

    @DisplayName("DoGame, 전략이 null 일 때")
    @Test
    void testDoGame02() {
        final RacingGame racingGame = new RacingGame(2, 2);

        assertThrows(AssertionError.class, () -> racingGame.doGame(null));
    }

}
