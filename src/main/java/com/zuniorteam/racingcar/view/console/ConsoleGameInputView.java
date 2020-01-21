package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.util.StringUtils;
import com.zuniorteam.racingcar.view.GameInputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsoleGameInputView implements GameInputView {

    private static final String CAR_NAMES_SPLIT_TOKEN = ",";

    @Override
    public GameInput listen() {
        final Scanner scanner = new Scanner(System.in);

        final List<String> numberOfCars = scanCarNames(scanner);
        final int numberOfStep = scanNumberOfStep(scanner);

        return new GameInput(numberOfCars, numberOfStep);
    }

    private List<String> scanCarNames(Scanner scanner) {
        System.out.println("자동차 이름을 입력주세용. [,] 구분");
        final String line = scanner.nextLine();

        final List<String> carNames = Arrays.stream(line.split(CAR_NAMES_SPLIT_TOKEN))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String carName : carNames) {
            validate(carName);
        }

        return carNames;
    }

    private void validate(String carName) {
        if (StringUtils.isEmpty(carName)) {
            throw new RuntimeException("자동차이 이름이 없습니다");
        }
    }


    private int scanNumberOfStep(Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

}
