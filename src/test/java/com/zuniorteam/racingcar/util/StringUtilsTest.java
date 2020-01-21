package com.zuniorteam.racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringUtilsTest {

    @DisplayName("empty")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "  " })
    void testIsEmpty(String value){
        assertThat(StringUtils.isEmpty(value)).isTrue();
    }

    @DisplayName("Not Empty")
    @ParameterizedTest
    @ValueSource(strings = { "a", "b  " })
    void testIsEmptyNot(String value){
        assertThat(StringUtils.isEmpty(value)).isFalse();
    }
}
