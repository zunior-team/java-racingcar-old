package com.zuniorteam.racingcar.core.vo;

import java.util.ArrayList;
import java.util.List;

public class StepResult {

    private final List<Integer> carResults;

    public StepResult(List<Integer> carResults) {
        assert carResults != null;

        this.carResults = new ArrayList<>(carResults);
    }
}
