package racingcar;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printRequestNumberOfCar();
        int numberOfCar = scanner.nextInt();

        printRequestNumberOfRound();
        int numberOfRound = scanner.nextInt();

        // racing game
        // init(number of car, number of round)
        // RacingGame racingGame = RacingGame.init(#c, #r);

        // play()
        // racingGame.play();

        // showResult()
        // racingGame.showResult();

    }

    private static void printRequestNumberOfCar() {
        System.out.print("자동차 대수는 몇 대 인가요? ");
    }

    private static void printRequestNumberOfRound() {
        System.out.print("시도할 횟수는 몇 회 인가요? ");
    }
}
