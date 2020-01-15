package com.zuniorteam.racingcar;

import com.zuniorteam.racingcar.strategy.MovingStrategy;

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

        final String result = doGame(numberOfCars, numberOfStep);

        printResult(result);
    }

    private void printResult(String result) {
        System.out.println("실행 결과 \n");
        System.out.println(result);
    }

    private int scanNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇대인가요?");
        return scanner.nextInt();
    }

    private int scanNumberOfStep(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    private String doGame(int numberOfCars, int numberOfStep) {
        final RacingGame racingGame = new RacingGame(numberOfCars, numberOfStep);
        return racingGame.doGame(movingStrategy);
    }

}
