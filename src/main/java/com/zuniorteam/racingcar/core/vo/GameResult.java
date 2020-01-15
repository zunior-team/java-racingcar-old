package com.zuniorteam.racingcar.core.vo;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<StepResult> stepResults;

    public GameResult(List<StepResult> stepResult) {
        assert stepResult != null;

        stepResults = new ArrayList<>(stepResult);
    }
}
