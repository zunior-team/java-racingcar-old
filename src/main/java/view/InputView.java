package view;

import game.RacingGame;
import random.RandomGenerator;
import strategy.RandomMovingStrategy;
import util.CommaSplitter;

import java.util.Random;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNamesInOneLine = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        final int countOfTurns = Integer.parseInt(scanner.nextLine());

        final Random generate = RandomGenerator.generate();
        final RandomMovingStrategy movingStrategy = new RandomMovingStrategy(generate);
        final RacingGame racingGame = RacingGame.newInstance(CommaSplitter.split(carNamesInOneLine), countOfTurns, movingStrategy);


        OutputView.print(racingGame);
    }
}
