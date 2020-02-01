package game.racinggame.dto;

import game.racinggame.util.RacingUtils;

import java.util.Arrays;
import java.util.List;

public class RacingCreateDto {

    private int tryCount;
    private List<String> carNames;

    public RacingCreateDto(final String carNames, final int tryCount){
        this.tryCount = tryCount;
        this.carNames = Arrays.asList(RacingUtils.splitLineByComma(carNames));
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getCarNameByIndex(final int index) {
        return carNames.get(index);
    }

    public int getCarSize() {
        return carNames.size();
    }
}
