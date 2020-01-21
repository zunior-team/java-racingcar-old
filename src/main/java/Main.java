import game.racing.car.event.Events;
import game.racing.car.event.GameOverEvent;
import game.racing.car.event.RoundOverEvent;
import game.racing.car.service.RacingGame;
import game.racing.car.view.RacingGameView;
import game.racing.car.view.impl.RacingGameConsoleView;

import java.util.List;

import static game.racing.car.view.InputConsoleView.inputCarNames;
import static game.racing.car.view.InputConsoleView.inputRoundCount;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String carNames = inputCarNames();
        Integer roundCount = inputRoundCount();

        RacingGame racingGame = new RacingGame(carNames, roundCount);
        RacingGameView racingGameView = new RacingGameConsoleView();

        registerRacingGameEvents(racingGameView);
        racingGameView.showGameProgressGuidanceMessage();
        racingGame.start();

        Events.reset();
    }

    private static void registerRacingGameEvents(RacingGameView racingGameView) {
        Events.handle((RoundOverEvent event) -> racingGameView.showCurrentPosition(event.getCarPositions()));
        Events.handle((GameOverEvent event) -> racingGameView.showGameResult(event.getWinners()));
    }
}