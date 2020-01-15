package com.zuniorteam.racingcar.gui;

import com.zuniorteam.racingcar.RacingGame;
import com.zuniorteam.racingcar.strategy.MovingStrategy;

import java.util.List;
import java.util.Scanner;

public class RacingGameBoard {

    private final MovingStrategy movingStrategy;

    public RacingGameBoard(MovingStrategy movingStrategy) {
        assert movingStrategy != null;

        this.movingStrategy = movingStrategy;
    }

    public void listen() {
        final Scanner scanner = new Scanner(System.in);

        final int numberOfCars = scanNumberOfCars(scanner);
        final int numberOfStep = scanNumberOfStep(scanner);

        final List<List<Integer>> result = doGame(numberOfCars, numberOfStep);

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

    private void printResult(List<List<Integer>> result) {
        System.out.println("실행 결과");
        System.out.println(GameResultViewMaker.makeGameResultView(result));
    }

    private List<List<Integer>> doGame(int numberOfCars, int numberOfStep) {
        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);
        return racingGame.doGame(movingStrategy);
    }

}
