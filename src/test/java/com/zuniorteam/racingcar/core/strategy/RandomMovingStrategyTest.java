package com.zuniorteam.racingcar.core.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

class RandomMovingStrategyTest {

    @DisplayName("New")
    @Test
    void testNewInstance() {
        assertDoesNotThrow(() -> new RandomMovingStrategy());
    }

    @DisplayName("New With, Random")
    @Test
    void testNewInstance02() {
        assertDoesNotThrow(() -> new RandomMovingStrategy(new Random()));
    }

    @DisplayName("New, null")
    @Test
    void testNewInstance03() {
        assertThrows(AssertionError.class, () -> new RandomMovingStrategy(null));
    }

    @DisplayName("Movable")
    @ParameterizedTest
    @CsvSource({
            "2, false",
            "3, false",
            "4, true",
            "5, true",
    })
    void testIsMovable(int randomValue, boolean expected) {
        //given
        final Random mockRandom = Mockito.mock(Random.class);
        given(mockRandom.nextInt(anyInt())).willReturn(randomValue);

        final RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(mockRandom);

        //when
        final boolean result = randomMovingStrategy.isMovable();

        //then
        assertThat(result).isEqualTo(expected);

    }
}
