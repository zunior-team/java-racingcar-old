package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.core.dto.GameResult;
import com.zuniorteam.racingcar.core.dto.StepResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultViewTest {

    @DisplayName("draw")
    @Test
    void testDraw() {
        //given
        final List<Integer> positionsA = Collections.singletonList(3);
        final StepResult stepResultA = new StepResult(positionsA);

        final List<Integer> positionsB = Collections.singletonList(2);
        final StepResult stepResultB = new StepResult(positionsB);

        final GameResult gameResult = new GameResult(Arrays.asList(stepResultA, stepResultB));

        //when
        final String result = GameResultView.draw(gameResult);

        //then
        assertThat(result).isEqualTo("---\n\n--");
    }
}
