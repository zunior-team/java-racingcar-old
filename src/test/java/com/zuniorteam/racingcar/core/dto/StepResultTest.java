package com.zuniorteam.racingcar.core.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
