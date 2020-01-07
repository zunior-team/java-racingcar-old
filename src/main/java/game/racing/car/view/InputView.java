package game.racing.car.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private Integer carCount;
    private Integer attempts;

    public void start() {
        carCount = inputCarCount();
        attempts = inputAttemptCount();
        System.out.println();
    }

    private Integer inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private Integer inputAttemptCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public Integer getCarCount() {
        return carCount;
    }

    public Integer getAttempts() {
        return attempts;
    }
}
