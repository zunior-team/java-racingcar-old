package game.racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("레이싱 유틸은")
class RacingUtilsTest {

    @ParameterizedTest
    @MethodSource("provideString")
    @DisplayName("들어온 문자열을 콤마로 자른다.")
    void splitLineByCommaTest(final String str, final int expectCount) {

        assertThat(RacingUtils.splitLineByComma(str).length)
                .isEqualTo(expectCount);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("들어온 문자열이 널이거나 공백인 경우 에러가 발생한다.")
    void illegalArgumentExceptionTest(final String str) {

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                RacingUtils.splitLineByComma(str));

        assertEquals("경주할 자동차 이름에 공백 또는 null 입력되었습니다.", exception.getMessage());
    }

    static Stream<Arguments> provideString() {
        return Stream.of(
                Arguments.of("씽씽, 붕붕", 2),
                Arguments.of("씽씽, 붕붕, 하하", 3)
        );
    }
}