package com.zuniorteam.racingcar.core.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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

    @DisplayName("print")
    @Test
    void testPrint(){

    }

}
