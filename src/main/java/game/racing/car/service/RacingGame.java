package game.racing.car.service;

import game.racing.car.event.Events;
import game.racing.car.event.GameOverEvent;
import game.racing.car.event.RoundOverEvent;
import game.racing.car.model.Cars;

import java.util.List;

import static game.racing.car.utils.RacingGameUtil.isAllNotEmpty;
import static game.racing.car.utils.RacingGameUtil.separateCarNames;

public class RacingGame {
    private static final Long WAIT_NEXT_ROUND = 500L;

    private Cars cars;
    private final Integer roundCount;

    public RacingGame(String carNameString, Integer roundCount) {
        String[] carNames = separateCarNames(carNameString);
        validate(carNames, roundCount);

        this.cars = new Cars(carNames);
        this.roundCount = roundCount;
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < roundCount; i++) {
            runRound();
            Thread.sleep(WAIT_NEXT_ROUND);
        }

        Events.raise(new GameOverEvent(cars.getWinnerNames()));
    }

    private void runRound() {
        cars.moveAll();
        Events.raise(new RoundOverEvent(cars.getPositionAll()));
    }

    private void validate(String[] carNames, Integer roundCount) {
        if(!isAllNotEmpty(carNames)) {
            throw new RuntimeException("car name length mush be bigger than zero.");
        }

        if (roundCount < 0) {
            throw new RuntimeException("round count must be bigger than zero.");
        }
    }
}
