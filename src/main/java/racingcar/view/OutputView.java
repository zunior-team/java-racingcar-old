package racingcar.view;

import racingcar.dto.RacingResult;

public class OutputView {
    public static void printResult(RacingResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getRaceHistory());
    }
}
