package racingcar.view;

import racingcar.dto.RacingCarResult;

public class OutputView {
    public static void printResult(RacingCarResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getResult());
    }
}
