package game.racing.car.view.impl;

import game.racing.car.view.RacingGameView;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    @Override
    public void showCurrentPosition(List<Integer> positions) {
        System.out.println("===============================================");
        positions.stream()
                .forEach(position -> printPositionSign(position));
        System.out.println();
    }

    private static void printPositionSign(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
