package game.racing.car;

import game.racing.car.view.RacingGameView;
import game.racing.car.view.impl.RacingGameConsoleView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameViewTests {
    //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String STRING_CRLF = "\r\n";

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName(value = "차 위치 출력 테스트")
    @ParameterizedTest
    @MethodSource
    void positionPrintTest(List<Integer> positions) {
        RacingGameView racingGameView = new RacingGameConsoleView();
        racingGameView.showCurrentPosition(positions);
        assertThat(expectedStringByPositions(positions)).isEqualTo(outContent.toString());
    }


    private static Stream positionPrintTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 6, 5)),
                Arguments.of(Arrays.asList(0, 2, 3)),
                Arguments.of(Arrays.asList(1, 2, 3))
        );
    }

    private static String expectedStringByPositions(List<Integer> positions) {
        StringBuilder stringBuilder = new StringBuilder();
        positions.stream()
                .forEach(position -> makeExpectedPositionString(stringBuilder, position));
        stringBuilder.append(STRING_CRLF);
        return stringBuilder.toString();
    }

    private static void makeExpectedPositionString(StringBuilder stringBuilder, Integer position) {
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append(STRING_CRLF);
    }
}
