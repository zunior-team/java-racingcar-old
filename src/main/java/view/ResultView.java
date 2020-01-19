package view;

import game.RacingResult;

import java.util.List;

import static game.RacingResult.NEXT_LINE_DELIMITER;

public class ResultView {
    private ResultView() {

    }

    public static void print(RacingResult result) {
        System.out.println("실행결과");
        printRacingResult(result);
    }

    private static void printRacingResult(RacingResult result) {
        StringBuilder resultInFormat = new StringBuilder();
        for (List<String> histories : result.getResult()) {
            resultInFormat.append(String.join(NEXT_LINE_DELIMITER, histories));
            resultInFormat.append(NEXT_LINE_DELIMITER);
            resultInFormat.append(NEXT_LINE_DELIMITER);
        }
        System.out.println(resultInFormat.toString());
    }
}



