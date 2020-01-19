import game.racing.car.service.RacingGame;
import game.racing.car.view.RacingGameView;
import game.racing.car.view.impl.RacingGameConsoleView;

import static game.racing.car.view.InputView.inputRoundCount;
import static game.racing.car.view.InputView.inputCarCount;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer carCount = inputCarCount();
        Integer roundCount = inputRoundCount();

        RacingGameView racingGameView = new RacingGameConsoleView();
        RacingGame racingGame = new RacingGame(carCount, roundCount, racingGameView);
        racingGame.start();
    }
}