package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.view.GameInputView;

import java.util.Scanner;

public class ConsoleGameInputView implements GameInputView {
    @Override
    public GameInput listen() {
        final Scanner scanner = new Scanner(System.in);

        final int numberOfCars = scanNumberOfCars(scanner);
        final int numberOfStep = scanNumberOfStep(scanner);

        return new GameInput(numberOfCars, numberOfStep);
    }

    private int scanNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇대인가요?");
        return scanner.nextInt();
    }

    private int scanNumberOfStep(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

}
