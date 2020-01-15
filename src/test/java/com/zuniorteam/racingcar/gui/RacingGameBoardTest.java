package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RacingGameBoardTest {

    @DisplayName("Racing Game Board 생성")
    @Test
    void testNewInstance01() {
        final RandomMovingStrategy movingStrategy = new RandomMovingStrategy();
        assertDoesNotThrow(() -> new RacingGameBoard(movingStrategy));
    }

    @DisplayName("Racing Game Board 생성, null")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new RacingGameBoard(null));
    }

}
