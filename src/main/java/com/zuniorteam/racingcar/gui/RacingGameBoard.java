package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.core.RacingGame;
import com.zuniorteam.racingcar.core.strategy.MovingStrategy;
import com.zuniorteam.racingcar.core.vo.GameResult;
import com.zuniorteam.racingcar.gui.drawer.PositionDrawer;

import java.util.Scanner;

public class RacingGameBoard {

    private final MovingStrategy movingStrategy;
    private final PositionDrawer positionDrawer;

    public RacingGameBoard(MovingStrategy movingStrategy, PositionDrawer positionDrawer) {
        assert movingStrategy != null;
        assert positionDrawer != null;

        this.positionDrawer = positionDrawer;
        this.movingStrategy = movingStrategy;
    }

    public void listen() {
        final Scanner scanner = new Scanner(System.in);

        final int numberOfCars = scanNumberOfCars(scanner);
        final int numberOfStep = scanNumberOfStep(scanner);

        final GameResult result = doGame(numberOfCars, numberOfStep);

        printResult(result);
    }

    private int scanNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇대인가요?");
        return scanner.nextInt();
    }

    private int scanNumberOfStep(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    private void printResult(GameResult result) {
        System.out.println("\n");
        System.out.println("실행 결과");
        System.out.println(result.print(positionDrawer));
    }

    private GameResult doGame(int numberOfCars, int numberOfStep) {
        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);
        return racingGame.doGame(movingStrategy);
    }

}
