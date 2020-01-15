package game.racing.car.service;

import game.racing.car.model.CarList;
import game.racing.car.view.RacingGameView;

public class RacingGame {
    private static final Long WAIT_NEXT_ATTEMPT = 500L;

    private CarList cars;
    private final Integer moveAttemptCount;

    private final RacingGameView racingGameView;

    public RacingGame(Integer carListSize, Integer moveAttemptCount, RacingGameView racingGameView) {
        this.cars = new CarList(carListSize);
        this.moveAttemptCount = moveAttemptCount;
        this.racingGameView = racingGameView;
    }

    public void start() throws InterruptedException {
        System.out.println("\n실행 결과\n");
        for (int i = 0; i < moveAttemptCount; i++) {
            moveAttempt();
            Thread.sleep(WAIT_NEXT_ATTEMPT);
        }
    }

    private void moveAttempt() {
        cars.moveAll();
        racingGameView.showCurrentPosition(cars.positionAll());
    }
}
