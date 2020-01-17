package com.zuniorteam.racingcar.core.dto;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;

public class StepResult {

    private final List<Integer> carPositions;

    public StepResult(List<Integer> carPositions) {
        assert carPositions != null;

        this.carPositions = carPositions;
    }

    @Getter
    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
