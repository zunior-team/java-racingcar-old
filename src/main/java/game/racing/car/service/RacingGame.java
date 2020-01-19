package game.racing.car.service;

import game.racing.car.model.Cars;
import game.racing.car.view.RacingGameView;

public class RacingGame {
    private static final Long WAIT_NEXT_ROUND = 500L;

    private Cars cars;
    private final Integer roundCount;

    private final RacingGameView racingGameView;

    public RacingGame(Integer carCount, Integer roundCount, RacingGameView racingGameView) {
        validate(carCount, roundCount);

        this.cars = new Cars(carCount);
        this.roundCount = roundCount;
        this.racingGameView = racingGameView;
    }

    private void validate(Integer carCount, Integer roundCount) {
        if (carCount < 0) {
            throw new RuntimeException("car count must be bigger than zero.");
        }

        if (roundCount < 0) {
            throw new RuntimeException("round count must be bigger than zero.");
        }
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < roundCount; i++) {
            runRound();
            Thread.sleep(WAIT_NEXT_ROUND);
        }
    }

    private void runRound() {
        cars.moveAll();
        racingGameView.showCurrentPosition(cars.getPositionAll());
    }
}
