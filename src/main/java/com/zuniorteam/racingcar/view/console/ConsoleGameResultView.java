package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.dto.GameResult;
import com.zuniorteam.racingcar.dto.StepResult;
import com.zuniorteam.racingcar.view.GameResultView;
import com.zuniorteam.racingcar.vo.MoveHistory;

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


        drawing.append("\n");
        drawing.append(drawWinners(result.getWinners()));

        System.out.println("실행 결과");

        System.out.println(drawing.toString().trim());


    }

    private String drawStep(StepResult stepResult) {
        final StringBuilder stepDrawing = new StringBuilder();
        final List<MoveHistory> moveHistories = stepResult.getMoveHistories();

        for (MoveHistory moveHistory : moveHistories) {
            stepDrawing
                    .append(moveHistory.getCarName())
                    .append(" : ")
                    .append(drawLine(moveHistory.getPosition()))
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

    private String drawWinners(List<String> carNames) {
        return "승자는 " + carNames + " 입니다";
    }

}
