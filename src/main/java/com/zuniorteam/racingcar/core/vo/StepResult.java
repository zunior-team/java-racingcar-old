package com.zuniorteam.racingcar.core.vo;

import com.zuniorteam.racingcar.gui.drawer.PositionDrawer;

import java.util.ArrayList;
import java.util.List;

public class StepResult {

    private final List<Integer> carPositions;

    public StepResult(List<Integer> carPositions) {
        assert carPositions != null;

        this.carPositions = new ArrayList<>(carPositions);
    }

    public String print(PositionDrawer positionDrawer) {
        final StringBuilder stepResultString = new StringBuilder();

        for (Integer position : carPositions) {
            stepResultString
                    .append(positionDrawer.draw(position))
                    .append("\n");
        }

        return stepResultString.toString();
    }
}
