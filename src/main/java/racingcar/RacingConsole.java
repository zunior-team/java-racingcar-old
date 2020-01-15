package racingcar;


import racingcar.dto.RacingCarInput;
import racingcar.dto.RacingResult;
import racingcar.racing.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingConsole {
    public static void main(String[] args) {
        RacingCarInput racingCarInput = InputView.receiveInput();

        Racing racing = new Racing(racingCarInput);
        racing.race();
        RacingResult result = racing.result();

        OutputView.printResult(result);
    }
}
