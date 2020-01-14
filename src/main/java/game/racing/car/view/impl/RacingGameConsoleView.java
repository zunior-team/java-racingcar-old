package game.racing.car.view.impl;

import game.racing.car.model.CarList;
import game.racing.car.view.RacingGameView;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    @Override
    public void showCurrentPosition(CarList carList) {
        List<Integer> carPositionList = carList.positionAll();
        carPositionList.stream().forEach(position -> printPositionMarker(position));
        System.out.println();
    }

    private void printPositionMarker(Integer position) {
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
