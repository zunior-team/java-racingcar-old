package game.racing.car.view;

import game.racing.car.model.vo.CarPosition;

import java.util.List;

public interface RacingGameView {
    void showCurrentPosition(List<CarPosition> carPositions);

    void showGameProgressGuidanceMessage();

    void showGameResult(List<String> winners);
}
