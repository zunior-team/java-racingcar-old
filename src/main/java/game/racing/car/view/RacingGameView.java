package game.racing.car.view;

import game.racing.car.model.vo.CarDto;

import java.util.List;

public interface RacingGameView {
    void showCurrentPosition(List<CarDto> carDtos);

    void showGameProgressGuidanceMessage();

    void showGameResult(List<String> winners);
}
