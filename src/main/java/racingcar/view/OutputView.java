package racingcar.view;

import racingcar.dto.RacingResult;

public class OutputView {
    public static void printResult(RacingResult result) {
        System.out.println("실행 결과");
        System.out.println(result.getRaceHistory());
        System.out.println(String.join(", ", result.getWinnerNames()) + "가 최종 우승했습니다.");
    }
}
