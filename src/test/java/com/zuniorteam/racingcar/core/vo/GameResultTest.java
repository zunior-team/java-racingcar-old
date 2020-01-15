package com.zuniorteam.racingcar.core.vo;

import com.zuniorteam.racingcar.gui.drawer.SimplePositionDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class GameResultTest {

    @DisplayName("New")
    @Test
    void testNewInstance(){
        assertDoesNotThrow(() -> new GameResult(Collections.emptyList()));
    }

    @DisplayName("New, Assertion Error")
    @Test
    void testNewInstance02(){
        assertThrows(AssertionError.class, () -> new GameResult(null));
    }

    @DisplayName("Get Draw")
    @Test
    void testGetDrawing(){
        //given
        final List<Integer> positionsA = Collections.singletonList(3);
        final StepResult stepResultA = new StepResult(positionsA);

        final List<Integer> positionsB = Collections.singletonList(2);
        final StepResult stepResultB = new StepResult(positionsB);

        final GameResult gameResult = new GameResult(Arrays.asList(stepResultA, stepResultB));

        //when
        final String result = gameResult.getDrawing(new SimplePositionDrawer());

        //then
        assertThat(result).isEqualTo("---\n\n--");
    }

}
