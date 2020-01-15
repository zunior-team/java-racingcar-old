package racingcar;


import racingcar.dto.RacingCarInput;
import racingcar.dto.RacingCarResult;
import racingcar.racing.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingConsole {
    public static void main(String[] args) {
        RacingCarInput racingCarInput = InputView.receiveInput();

        RacingCar racingCar = new RacingCar(racingCarInput);
        racingCar.race();
        RacingCarResult result = racingCar.result();

        OutputView.printResult(result);
    }
}
