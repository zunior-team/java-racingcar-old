package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.view.GameInputView;
import com.zuniorteam.racingcar.view.GameResultView;

import java.util.Objects;

public class RacingGameBoard {

    private final GameInputView gameInputView;
    private final GameResultView gameResultVew;

    public RacingGameBoard(GameInputView gameInputView, GameResultView gameResultView) {
        assert gameInputView != null;
        assert gameResultView != null;

        this.gameInputView = gameInputView;
        this.gameResultVew = gameResultView;
    }

    public void start(MovingStrategy movingStrategy) {
        validate(movingStrategy);

        final GameInput gameInput = gameInputView.listen();
        final GameResult result = doGame(gameInput, movingStrategy);

        gameResultVew.draw(result);
    }

    private void validate(MovingStrategy movingStrategy) {
        if (Objects.isNull(movingStrategy)) {
            throw new RuntimeException("무빙전략을 지정해주세요");
        }
    }

    private GameResult doGame(GameInput gameInput, MovingStrategy movingStrategy) {
        final RacingGame racingGame = new RacingGame(gameInput);
        return racingGame.doGame(movingStrategy);
    }

}
