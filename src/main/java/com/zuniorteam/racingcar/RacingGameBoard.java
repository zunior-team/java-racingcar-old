package com.zuniorteam.racingcar;

import com.sun.istack.internal.NotNull;
import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.view.GameInputView;
import com.zuniorteam.racingcar.view.GameResultView;

import java.util.Objects;

public class RacingGameBoard {

    private final MovingStrategy movingStrategy;

    public RacingGameBoard(MovingStrategy movingStrategy) {
        assert movingStrategy != null;

        this.movingStrategy = movingStrategy;
    }

    public void start(@NotNull GameInputView gameInputView, @NotNull GameResultView gameResultView) {
        validate(gameInputView, gameResultView);

        final GameInput gameInput = gameInputView.listen();
        final GameResult result = doGame(gameInput.getNumberOfCars(), gameInput.getNumberOfStep());

        gameResultView.draw(result);
    }

    private void validate(GameInputView gameInputView, GameResultView gameResultView) {
        if (Objects.isNull(gameInputView)) {
            throw new RuntimeException("게임 INPUT VIEW 를 지정해주세요");
        }

        if (Objects.isNull(gameResultView)) {
            throw new RuntimeException("게임 OUTPUT VIEW 를 지정해주세요");
        }
    }

    private GameResult doGame(int numberOfCars, int numberOfStep) {
        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);
        return racingGame.doGame(movingStrategy);
    }

}
