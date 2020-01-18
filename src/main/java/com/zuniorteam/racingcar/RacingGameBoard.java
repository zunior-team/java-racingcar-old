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
        assert gameInputView != null;
        assert gameResultView != null;


        final GameInput gameInput = gameInputView.listen();
        final GameResult result = doGame(gameInput.getNumberOfCars(), gameInput.getNumberOfStep());

        gameResultView.draw(result);
    }

    private GameResult doGame(int numberOfCars, int numberOfStep) {
        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);
        return racingGame.doGame(movingStrategy);
    }

}
