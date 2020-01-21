package game.racing.car.view.impl;

import game.racing.car.model.Cars;
import game.racing.car.model.vo.CarPosition;
import game.racing.car.view.RacingGameView;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    @Override
    public void showCurrentPosition(Cars cars) {
        cars.getPositionAll()
                .stream()
                .forEach(carPosition -> printPositionSign(carPosition));
        System.out.println();
    }

    @Override
    public void showGameProgressGuidanceMessage() {
        System.out.println("\n실행 결과\n");
        System.out.println("===============================================");
    }

    private static void printPositionSign(CarPosition position) {
        System.out.print(position.getCarName() + " : ");
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
