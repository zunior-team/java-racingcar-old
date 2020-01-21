package game.racing.car.view.impl;

import game.racing.car.model.vo.CarPosition;
import game.racing.car.view.RacingGameView;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    @Override
    public void showCurrentPosition(List<CarPosition> carPositions) {
        carPositions.stream()
                .forEach(carPosition -> printPosition(carPosition));
        System.out.println();
    }

    @Override
    public void showGameProgressGuidanceMessage() {
        System.out.println("\n실행 결과\n");
        System.out.println("===============================================");
    }

    @Override
    public void showGameResult(List<String> winners) {
        String winnerString = String.join(", ", winners);
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }


    private static void printPosition(CarPosition position) {
        System.out.print(position.getCarName() + " : ");
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
