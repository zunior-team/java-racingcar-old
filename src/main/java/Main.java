import game.racing.car.event.Events;
import game.racing.car.event.RoundOverEvent;
import game.racing.car.service.RacingGame;
import game.racing.car.view.InputView;
import game.racing.car.view.RacingGameView;
import game.racing.car.view.impl.RacingGameConsoleView;

import static game.racing.car.view.impl.InputConsoleView.inputRoundCount;
import static game.racing.car.view.impl.InputConsoleView.inputCarCount;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer carCount = InputView.inputCarCount();
        Integer roundCount = InputView.inputRoundCount();

        RacingGame racingGame = new RacingGame(carCount, roundCount);
        RacingGameView racingGameView = new RacingGameConsoleView();

        Events.handle((RoundOverEvent event) -> racingGameView.showCurrentPosition(event.getCarPositions()));

        racingGameView.showGameProgressGuidanceMessage();
        racingGame.start();

        Events.reset();
    }
}