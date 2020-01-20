package game.racing.car.view;

import game.racing.car.model.Cars;

public interface RacingGameView {
    void showCurrentPosition(Cars cars);

    void showGameProgressGuidanceMessage();
}
