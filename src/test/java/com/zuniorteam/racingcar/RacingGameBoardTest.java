package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.RacingGameBoard;
import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.view.console.ConsoleGameInputView;
import com.zuniorteam.racingcar.view.console.ConsoleGameResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameBoardTest {

    @DisplayName("Racing Game Board 생성")
    @Test
    void testNewInstance01() {
        //given
        final RandomMovingStrategy movingStrategy = new RandomMovingStrategy();

        //when, then
        assertDoesNotThrow(() -> new RacingGameBoard(movingStrategy));
    }

    @DisplayName("Racing Game Board 생성, null")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new RacingGameBoard(null));
    }

    @DisplayName("Start")
    @Test
    void testStart() {

        final RacingGameBoard racingGameBoard = new RacingGameBoard(new RandomMovingStrategy());

        assertAll(
                () -> assertThrows(RuntimeException.class, () -> racingGameBoard.start(null, null)),
                () -> assertThrows(RuntimeException.class, () -> racingGameBoard.start(new ConsoleGameInputView(), null)),
                () -> assertThrows(RuntimeException.class, () -> racingGameBoard.start(null, new ConsoleGameResultView()))
        );
    }

}
