package com.zuniorteam.racingcar.gui;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultViewMakerTest {

    @Test
    void testMakeResultString(){
        //given
        final List<Integer>  stepResult = Arrays.asList(1, 2);
        final List<List<Integer>> gameResult = Collections.singletonList(stepResult);

        final StringBuilder expected = new StringBuilder();

        expected
                .append("-")
                .append("\n")
                .append("-")
                .append("-");

        //then
        final String resultString = GameResultViewMaker.makeGameResultView(gameResult);

        //result
        assertThat(resultString).isEqualTo(expected.toString());
    }
}
