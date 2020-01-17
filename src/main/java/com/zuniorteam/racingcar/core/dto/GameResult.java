package com.zuniorteam.racingcar.core.dto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<StepResult> stepResults;

    public GameResult(List<StepResult> stepResults) {
        assert stepResults != null;

        this.stepResults = new ArrayList<>(stepResults);
    }

    public List<StepResult> getStepResults() {
        return new ArrayList<>(stepResults);
    }
}
