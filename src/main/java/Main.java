import game.racing.car.service.RacingGame;
import game.racing.car.view.impl.RacingGameConsoleView;

import static game.racing.car.view.InputView.inputAttemptCount;
import static game.racing.car.view.InputView.inputCarCount;

public class Main {
    public static void main(String[] args) {
        Integer carCount = inputCarCount();
        Integer attemptCount = inputAttemptCount();
        RacingGame racingGame = new RacingGame(carCount, attemptCount, new RacingGameConsoleView());
        racingGame.start();
    }
}