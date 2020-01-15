package com.zuniorteam.racingcar.core.vo;

import com.zuniorteam.racingcar.gui.drawer.SimplePositionDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StepResultTest {


    @DisplayName("New")
    @Test
    void testNewInstance(){
        assertDoesNotThrow(() -> new StepResult(Collections.emptyList()));
    }

    @DisplayName("New, Assertion Error")
    @Test
    void testNewInstance02(){
        assertThrows(AssertionError.class, () -> new StepResult(null));
    }

    @DisplayName("Print Result")
    @Test
    void testPrint(){
        //given
        final List<Integer> positions = Collections.singletonList(3);
        final StepResult stepResult = new StepResult(positions);

        //when
        final String result = stepResult.print(new SimplePositionDrawer());

        //then
        assertThat(result).isEqualTo("---\n");
    }

}
