package com.zuniorteam.racingcar.dto;

import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class GameResult {

    private final List<String> winners;
    private final List<StepResult> stepResults;

    public GameResult(List<StepResult> stepResults) {
        assert stepResults != null;

        this.stepResults = stepResults;
        this.winners = getWinners(stepResults);
    }

    private List<String> getWinners(List<StepResult> stepResults) {
        final StepResult lastStepResult = stepResults.get(stepResults.size() - 1);

        final List<MoveHistory> lastMoveHistories = lastStepResult.getMoveHistories();

        final List<MoveHistory> sortedMoveHistoriesByPosition = lastMoveHistories.stream()
                .sorted(Comparator.comparingInt(MoveHistory::getPosition))
                .collect(toList());

        return sortedMoveHistoriesByPosition.stream()
                .filter(h -> sortedMoveHistoriesByPosition.get(0).getPosition() == h.getPosition())
                .map(MoveHistory::getCarName)
                .collect(toList());
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<StepResult> getStepResults() {
        return stepResults;
    }


}
