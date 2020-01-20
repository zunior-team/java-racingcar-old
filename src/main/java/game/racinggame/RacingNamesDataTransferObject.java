package game.racinggame;

import java.util.List;

public class RacingNamesDataTransferObject {

    private List<String> carNames;
    private int tryCount;

    public RacingNamesDataTransferObject(final List<String> carNames, final int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    List<String> getCarNames() {
        return this.carNames;
    }

    int getTryCount() {
        return this.tryCount;
    }
}
