package racingcar.view;

import racingcar.dto.RacingCarInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_REGEX = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static RacingCarInput receiveInput() {
        printRequestNumberOfCar();
        List<String> candidates = Arrays.asList(scanner.nextLine().split(SPLIT_REGEX));

        printRequestNumberOfRound();
        int numberOfRound = scanner.nextInt();

        return new RacingCarInput(candidates, numberOfRound);
    }

    private static void printRequestNumberOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ");
    }

    private static void printRequestNumberOfRound() {
        System.out.print("시도할 횟수는 몇 회 인가요? ");
    }
}
