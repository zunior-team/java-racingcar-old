package game.racing.car.service;

import game.racing.car.model.CarList;
import game.racing.car.view.RacingGameView;

public class RacingGame {
    private Integer moveAttemptCount;
    private CarList carList;

    private RacingGameView racingGameView;

    public RacingGame(Integer moveAttemptCount, Integer carListSize, RacingGameView racingGameView) {
        this.moveAttemptCount = moveAttemptCount;
        this.carList = new CarList(carListSize);
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
