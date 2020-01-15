package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.core.strategy.RandomMovingStrategy;
import com.zuniorteam.racingcar.gui.drawer.SimplePositionDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RacingGameBoardTest {

    @DisplayName("Racing Game Board 생성")
    @Test
    void testNewInstance01() {
        //given
        final RandomMovingStrategy movingStrategy = new RandomMovingStrategy();
        final SimplePositionDrawer simpleLineDrawer = new SimplePositionDrawer();

        //when, then
        assertDoesNotThrow(() -> new RacingGameBoard(movingStrategy, simpleLineDrawer));
    }

    @DisplayName("Racing Game Board 생성, null")
    @Test
    void testNewInstance02() {

        assertAll(
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(new RandomMovingStrategy(), null)),
                () -> assertThrows(AssertionError.class, () -> new RacingGameBoard(null, new SimplePositionDrawer()))
        );

    }

}
