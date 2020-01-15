package com.zuniorteam.racingcar.core;

import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.vo.GameResult;
import com.zuniorteam.racingcar.core.vo.StepResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private final List<Car> cars;
    private final int numberOfStep;

    public RacingGame(int numberOfCars, int numberOfStep) {
        this.cars = initCars(numberOfCars);
        this.numberOfStep = numberOfStep;

        validate();
    }

    private List<Car> initCars(int numberOfCars) {
        return IntStream.rangeClosed(0, numberOfCars - 1)
                .mapToObj((index) -> new Car())
                .collect(toList());
    }

    private void validate() {
        if(this.cars.isEmpty()){
            throw new RuntimeException("자동차가 0대 입니다");
        }

        if(this.numberOfStep == 0){
            throw new RuntimeException("요청한 이동 횟수가 0 입니다");
        }
    }


    public GameResult doGame(MovingStrategy movingStrategy) {
        assert movingStrategy != null : "MovingStrategy is null";

        final List<StepResult> stepResults = new ArrayList<>();

        for(int step = 0; step < numberOfStep; step++){
            stepResults.add(doStep(movingStrategy));
        }

        return new GameResult(stepResults);
    }

    private StepResult doStep(MovingStrategy movingStrategy) {
        final ArrayList<Integer> stepResult = new ArrayList<>();

        for (Car car : cars) {
            stepResult.add(car.move(movingStrategy));
        }

        return new StepResult(stepResult);
    }
}
