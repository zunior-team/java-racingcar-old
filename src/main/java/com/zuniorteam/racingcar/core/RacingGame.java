package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.dto.GameResult;
import com.zuniorteam.racingcar.core.dto.StepResult;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int numberOfStep;
    private final Cars cars;

    public RacingGame(int numberOfCars, int numberOfStep) {
        validate(numberOfStep);

        this.cars = new Cars(numberOfCars);
        this.numberOfStep = numberOfStep;
    }

    private void validate(int numberOfStep) {
        if (numberOfStep <= 0) {
            throw new RuntimeException("요청한 이동 횟수가 0 이하 입니다");
        }
    }

    public GameResult doGame(MovingStrategy movingStrategy) {
        assert movingStrategy != null : "MovingStrategy is null";

        final List<StepResult> stepResults = new ArrayList<>();

        for (int step = 0; step < numberOfStep; step++) {
            stepResults.add(doStep(movingStrategy));
        }

        return new GameResult(stepResults);
    }

    private StepResult doStep(MovingStrategy movingStrategy) {

        cars.moveAll(movingStrategy);

        return new StepResult(cars.getCurrentPositions());
    }
}
