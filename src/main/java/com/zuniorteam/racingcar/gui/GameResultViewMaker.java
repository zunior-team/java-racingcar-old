package com.zuniorteam.racingcar.gui;

import java.util.List;

public class GameResultViewMaker {
    public static String makeGameResultView(List<List<Integer>> gameResult) {
        final StringBuilder gameResultString = new StringBuilder();
        for (List<Integer> stepResult : gameResult) {

            gameResultString
                    .append(makeStepResultView(stepResult))
                    .append("\n");

        }

        return gameResultString.toString().trim();
    }

    private static String makeStepResultView(List<Integer> stepResult) {
        final StringBuilder stepResultString = new StringBuilder();

        for (Integer position : stepResult) {
            stepResultString
                    .append(makeLine(position))
                    .append("\n");
        }

        return stepResultString.toString();
    }

    private static String makeLine(Integer position) {
        final StringBuilder line = new StringBuilder();

        for(int i = 0 ;i < position; i++){
            line.append("-");
        }

        return line.toString();
    }
}
