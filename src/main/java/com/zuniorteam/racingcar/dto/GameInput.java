package com.zuniorteam.racingcar.dto;


import java.util.List;

public class GameInput {

    private final List<String> carNames;
    private final int numberOfStep;

    public GameInput(List<String> carNames, int numberOfStep) {
        this.carNames = carNames;
        this.numberOfStep = numberOfStep;
    }


    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfStep() {
        return numberOfStep;
    }
}
