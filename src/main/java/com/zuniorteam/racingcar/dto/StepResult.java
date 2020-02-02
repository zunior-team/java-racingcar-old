package com.zuniorteam.racingcar.dto;

import com.zuniorteam.racingcar.vo.MoveHistory;

import java.util.List;

public class StepResult {

    private final List<MoveHistory> moveHistories;

    public StepResult(List<MoveHistory> moveHistories) {
        assert moveHistories != null;

        this.moveHistories = moveHistories;
    }

    public List<MoveHistory> getMoveHistories() {
        return moveHistories;
    }
}
