package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.dto.StepResult;
import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int numberOfStep;

    public RacingGame(GameInput gameInput) {
        final int numberOfStep = gameInput.getNumberOfStep();

        validate(numberOfStep);

        this.cars = new Cars(gameInput.getCarNames());
        this.numberOfStep = numberOfStep;
    }

    private void validate(int numberOfStep) {
        if (numberOfStep <= 0) {
            throw new RuntimeException("요청한 이동 횟수가 0 이하 입니다");
        }
    }

    public GameResult doGame(MovingStrategy movingStrategy) {
        final List<StepResult> stepResults = new ArrayList<>();

        for (int step = 0; step < numberOfStep; step++) {
            stepResults.add(doStep(cars, movingStrategy));
        }

        final List<String> winner = cars.getCarNamesHasTopPosition();

        return new GameResult(winner, stepResults);
    }

    private StepResult doStep(Cars cars, MovingStrategy movingStrategy) {
        cars.moveAll(movingStrategy);
        return new StepResult(cars.getLastMoveHistories());
    }

}
