package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.dto.GameInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

class RacingGameTest {

    @DisplayName("생성 테스트")
    @Test
    void testNewInstance01() {
        final GameInput gameInput = new GameInput(Collections.singletonList("helloCar"), 1);
        assertDoesNotThrow(() -> new RacingGame(gameInput));
    }

    @DisplayName("생성 테스트, 차가 이름이 없거나, 횟수가 0 일때")
    @ParameterizedTest(name = "자동차이름 : {0}, 횟수 : {1}")
    @CsvSource({
            " , 0",
            " , 1",
            "a, 0",
    })
    void testNewInstance02(String carNames, int numberOfStep) {
        final GameInput gameInput = new GameInput(Collections.singletonList(carNames), numberOfStep);
        assertThrows(RuntimeException.class, () -> new RacingGame(gameInput));
    }

    @DisplayName("DoGame 테스트")
    @Test
    void testDoGame01() {
        //given
        final GameInput gameInput = new GameInput( Collections.singletonList("helloCar"), 1);

        final RacingGame racingGame = new RacingGame(gameInput);

        final MovingStrategy mockMovingStrategy = Mockito.mock(MovingStrategy.class);
        given(mockMovingStrategy.isMovable()).willReturn(true);

        //when, then
        assertDoesNotThrow(() -> racingGame.doGame(mockMovingStrategy));
    }
}
