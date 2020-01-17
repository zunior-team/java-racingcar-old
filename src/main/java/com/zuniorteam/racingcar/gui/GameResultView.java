package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.core.dto.GameResult;
import com.zuniorteam.racingcar.core.dto.StepResult;

import java.util.List;

public final class GameResultView {

    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";

    private GameResultView() {
    }

    public static String draw(GameResult result) {
        final StringBuilder drawing = new StringBuilder();

        final List<StepResult> stepResults = result.getStepResults();
        for (StepResult stepResult : stepResults) {
            drawing.append(drawStep(stepResult))
                    .append("\n");
        }

        return drawing.toString().trim();
    }

    private static String drawStep(StepResult stepResult) {
        final StringBuilder stepDrawing = new StringBuilder();
        final List<Integer> carPositions = stepResult.getCarPositions();

        for (Integer position : carPositions) {
            stepDrawing.append(drawLine(position))
                    .append(NEW_LINE);
        }

        return stepDrawing.toString();
    }

    private static String drawLine(Integer position) {
        final StringBuilder line = new StringBuilder();
        for (int i = 0; i < position; i++) {
            line.append(DASH);
        }

        return line.toString();
    }
}
