package game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("레이싱 게임 콘솔창에")
public class RacingConsoleTest {

    // https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private RacingConsole console;

    @BeforeAll
    void setup() {
        console = RacingConsole.create();
    }

    @Test
    @DisplayName("자동차 대수를 묻도록 한다.")
    void printAskCarNumberMessageTest() {

    }

    @Test
    @DisplayName("시도할 횟수를 묻도록 한다.")
    void printAskTryCountMessageTest() {

    }

    @Test
    @DisplayName("실행 결과를 묻도록 한다.")
    void printGameResultMessageTest() {

    }
}
