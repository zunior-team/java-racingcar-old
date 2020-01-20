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

    public List<List<String>> getResult(){
        return this.result;
    }

}
