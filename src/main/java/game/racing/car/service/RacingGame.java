package game.racing.car.service;

import game.racing.car.model.CarList;
import game.racing.car.view.RacingGameView;

public class RacingGame {
    private CarList carList;
    private Integer moveAttemptCount;

    private RacingGameView racingGameView;

    public RacingGame(Integer carListSize, Integer moveAttemptCount, RacingGameView racingGameView) {
        this.carList = new CarList(carListSize);
        this.moveAttemptCount = moveAttemptCount;
        this.racingGameView = racingGameView;
    }

    public void start() {
        for (int i = 0; i < moveAttemptCount; i++) {
            moveAttempt();
        }
    }

    private void moveAttempt() {
        carList.moveAll();
        racingGameView.showCurrentPosition(carList);
    }
}
