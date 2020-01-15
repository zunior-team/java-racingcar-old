package com.zuniorteam.racingcar.core.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RandomMovingStrategyTest {

    @DisplayName("New")
    @Test
    void testNewInstance() {
        assertDoesNotThrow(RandomMovingStrategy::new);
    }
}
