package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.view.GameInputView;
import com.zuniorteam.racingcar.view.GameResultView;
import com.zuniorteam.racingcar.view.console.ConsoleGameInputView;
import com.zuniorteam.racingcar.view.console.ConsoleGameResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameBoardTest {

    @DisplayName("New Instance, Assert 에러")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new RacingGameBoard(new ConsoleGameInputView(), new ConsoleGameResultView()));
    }

    @DisplayName("New Instance, Assert 에러")
    @Test
    void testNewInstance02() {

        assertAll(
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(new ConsoleGameInputView(), null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, new ConsoleGameResultView()))
        );
    }

}
