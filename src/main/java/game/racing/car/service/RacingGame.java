package game.racing.car.service;

import game.racing.car.event.Events;
import game.racing.car.event.RoundOverEvent;
import game.racing.car.model.Cars;
import game.racing.car.view.RacingGameView;

public class RacingGame {
    private static final Long WAIT_NEXT_ROUND = 500L;

    private Cars cars;
    private final Integer roundCount;

    public RacingGame(Integer carCount, Integer roundCount) {
        validate(carCount, roundCount);

        this.cars = new Cars(carCount);
        this.roundCount = roundCount;
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < roundCount; i++) {
            runRound();
            Thread.sleep(WAIT_NEXT_ROUND);
        }
    }

    private void runRound() {
        cars.moveAll();
        Events.raise(new RoundOverEvent(cars.getPositionAll()));
    }

    private void validate(Integer carCount, Integer roundCount) {
        if (carCount < 0) {
            throw new RuntimeException("car count must be bigger than zero.");
        }

        if (roundCount < 0) {
            throw new RuntimeException("round count must be bigger than zero.");
        }
    }
}
