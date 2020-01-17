package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.core.dto.GameResult;
import com.zuniorteam.racingcar.core.dto.StepResult;
import com.zuniorteam.racingcar.view.GameResultView;

import java.util.List;

public class ConsoleGameResultView implements GameResultView {

    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";

    public void draw(GameResult result) {

        final StringBuilder drawing = new StringBuilder();

        final List<StepResult> stepResults = result.getStepResults();
        for (StepResult stepResult : stepResults) {
            drawing.append(drawStep(stepResult))
                    .append("\n");
        }

        System.out.println("실행 결과");
        System.out.println(drawing.toString().trim());

    }

    private String drawStep(StepResult stepResult) {
        final StringBuilder stepDrawing = new StringBuilder();
        final List<Integer> carPositions = stepResult.getCarPositions();

        for (Integer position : carPositions) {
            stepDrawing.append(drawLine(position))
                    .append(NEW_LINE);
        }

        return stepDrawing.toString();
    }

    private String drawLine(Integer position) {
        final StringBuilder line = new StringBuilder();
        for (int i = 0; i < position; i++) {
            line.append(DASH);
        }

        return line.toString();
    }
}
