package com.zuniorteam.racingcar.core.vo;

import com.zuniorteam.racingcar.gui.drawer.PositionDrawer;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<StepResult> stepResults;

    public GameResult(List<StepResult> stepResults) {
        assert stepResults != null;

        this.stepResults = new ArrayList<>(stepResults);
    }

    public String getDrawing(PositionDrawer positionDrawer) {
        final StringBuilder gameResultString = new StringBuilder();

        for (StepResult stepResult : stepResults) {
            gameResultString
                    .append(stepResult.getDrawing(positionDrawer))
                    .append("\n");
        }

        return gameResultString.toString().trim();
    }
}
