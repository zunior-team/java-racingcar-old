package game.racing.car;

import game.racing.car.model.Car;
import game.racing.car.model.vo.CarDto;
import game.racing.car.service.MovingStrategy;
import game.racing.car.view.RacingGameView;
import game.racing.car.view.impl.RacingGameConsoleView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RacingGameViewTests {
    //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String STRING_CRLF = "\r\n";
    private static final String NEW_LINE = "\n";

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
    @ExtendWith(MockitoExtension.class)
    @MethodSource
    void positionPrintTest(List<String> carNames, List<Integer> positions) {
        RacingGameView racingGameView = new RacingGameConsoleView();
        List<CarDto> carDtos = makeCarTestDtos(carNames, positions);
        racingGameView.showCurrentPosition(carDtos);
        assertThat(outContent.toString()).isEqualTo(expectedStringByPositions(carNames, positions));
    }

    private List<CarDto> makeCarTestDtos(List<String> carNames, List<Integer> positions) {
        return IntStream.range(0, carNames.size())
                .mapToObj(i -> new Car(carNames.get(i), positions.get(i), mock(MovingStrategy.class)).makeCarDto())
                .collect(Collectors.toList());
    }


    private static Stream positionPrintTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), Arrays.asList(3, 6, 5)),
                Arguments.of(Arrays.asList("paul1", "paul2", "paul3"), Arrays.asList(0, 2, 3)),
                Arguments.of(Arrays.asList("abc", "bcd", "cde"), Arrays.asList(1, 2, 3))
        );
    }

    private static String expectedStringByPositions(List<String> carNames, List<Integer> positions) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, positions.size())
                .forEach(i -> makeExpectedPositionString(stringBuilder, carNames.get(i), positions.get(i)));
        stringBuilder.append(STRING_CRLF);
        return stringBuilder.toString();
    }

    private static void makeExpectedPositionString(StringBuilder stringBuilder, String carName, Integer position) {
        stringBuilder.append(carName)
                .append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append(STRING_CRLF);
    }
}
