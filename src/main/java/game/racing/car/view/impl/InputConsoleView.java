package game.racing.car.view.impl;

import game.racing.car.view.InputView;

import java.util.Scanner;

public class InputConsoleView implements InputView {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public Integer inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    @Override
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    @Override
    public Integer inputRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
