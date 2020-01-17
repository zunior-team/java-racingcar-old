package com.zuniorteam.racingcar.core.dto;


public class GameInput {

    private final int numberOfCars;
    private final int numberOfStep;

    public GameInput(int numberOfCars, int numberOfStep) {
        this.numberOfCars = numberOfCars;
        this.numberOfStep = numberOfStep;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfStep() {
        return numberOfStep;
    }
}
