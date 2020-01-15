package view;

import game.RacingResult;

public class ResultView {
    private ResultView() {

    }
    public static void print(RacingResult result) {
        System.out.println("실행결과");
        System.out.println(result.getAllHistoryInResultViewFormat());
    }
}
