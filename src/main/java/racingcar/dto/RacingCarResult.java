package racingcar.dto;

public class RacingCarResult {
    String result;

    public RacingCarResult(String raceHistory) {
        this.result = raceHistory;
    }

    public String getResult() {
        return result;
    }
}
