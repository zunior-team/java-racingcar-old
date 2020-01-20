package view;

import game.RacingGame;
import random.RandomGenerator;
import strategy.RandomMovingStrategy;

import java.util.Random;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        final int numberOfCars = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        final int countOfTurns = Integer.parseInt(scanner.nextLine());

        final Random generate = RandomGenerator.generate();
        final RandomMovingStrategy movingStrategy = new RandomMovingStrategy(generate);
        final RacingGame racingGame = RacingGame.newInstance(numberOfCars, countOfTurns, movingStrategy);

        ResultView.print(racingGame.proceedAllAndGetResult());
    }
}
