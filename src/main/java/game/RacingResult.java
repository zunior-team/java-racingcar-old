package game;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public static final String NEXT_LINE_DELIMITER = "\n";
    private final List<List<String>> result = new ArrayList<>();

    private RacingResult(){

    }

    public static RacingResult newInstance() {
        return new RacingResult();
    }

    public void add(List<String> histories) {
        this.result.add(histories);
    }

    public String getAllHistoryInResultViewFormat() {
        StringBuilder resultInFormat = new StringBuilder();
        for (List<String> histories : result) {
            resultInFormat.append(String.join(NEXT_LINE_DELIMITER, histories));
            resultInFormat.append(NEXT_LINE_DELIMITER);
            resultInFormat.append(NEXT_LINE_DELIMITER);
        }
        return resultInFormat.toString();
    }
}
