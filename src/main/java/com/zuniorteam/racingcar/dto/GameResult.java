package com.zuniorteam.racingcar.dto;

import java.util.List;

public class GameResult {

    private final List<String> winners;
    private final List<StepResult> stepResults;

    public GameResult(List<String> winners, List<StepResult> stepResults) {
        assert winners != null;
        assert stepResults != null;

        this.winners = winners;
        this.stepResults = stepResults;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<StepResult> getStepResults() {
        return stepResults;
    }


}
