package com.zuniorteam.racingcar.gui.drawer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimplePositionDrawerTest {

    @DisplayName("Draw")
    @Test
    void testDraw(){

        //given
        final int position = 4;
        final String expected = "----";

        //when
        final String result = new SimplePositionDrawer().draw(position);

        //then
        assertThat(result).isEqualTo(expected);

    }

}