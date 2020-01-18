package com.zuniorteam.racingcar.dto;

import java.util.List;

public class StepResult {

    private final List<Integer> carPositions;

    public StepResult(List<Integer> carPositions) {
        assert carPositions != null;

        this.carPositions = carPositions;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
