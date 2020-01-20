package racingcar.view;

import racingcar.dto.RacingCarInput;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static RacingCarInput receiveInput() {
        printRequestNumberOfCar();
        int numberOfCar = scanner.nextInt();

        printRequestNumberOfRound();
        int numberOfRound = scanner.nextInt();

        return new RacingCarInput(numberOfCar, numberOfRound);
    }

    private static void printRequestNumberOfCar() {
        System.out.print("자동차 대수는 몇 대 인가요? ");
    }

    private static void printRequestNumberOfRound() {
        System.out.print("시도할 횟수는 몇 회 인가요? ");
    }
}
