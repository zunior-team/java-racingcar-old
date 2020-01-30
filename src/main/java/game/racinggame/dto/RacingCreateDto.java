package game.racinggame.dto;

import java.util.Arrays;
import java.util.List;

public class RacingCreateDto {

    private static final String COMMA = ",";
    private int tryCount;
    private List<String> carNames;

    public RacingCreateDto(final String carNames, final int tryCount){
        this.tryCount = tryCount;
        this.carNames = Arrays.asList(carNames.split(COMMA));
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public String getCarNameByIndex(final int index) {
        return carNames.get(index);
    }
}
