package game.racing.car.view.impl;

import game.racing.car.view.RacingGameView;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    @Override
    public void showCurrentPosition(List<Integer> positions) {
        positions.stream()
                .forEach(position -> printPositionMarker(position));
        System.out.println();
    }

    private static void printPositionMarker(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
