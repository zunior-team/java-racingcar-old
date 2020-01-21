package com.zuniorteam.racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoveHistoryTest {

    @DisplayName("New")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new MoveHistory("helloCar", 0));
    }

    @DisplayName("New, 이름이 null 또는 empty")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void testNewInstance02(String carName) {
        assertThrows(AssertionError.class, () -> new MoveHistory(carName, 0));
    }


}
