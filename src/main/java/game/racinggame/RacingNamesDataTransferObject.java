package game.racinggame;

import java.util.List;

public class RacingNamesDataTransferObject {

    private List<String> carNames;
    private int carNumber;
    private int tryCount;

    public RacingNamesDataTransferObject(final List<String> carNames, final int tryCount) {
        this.carNames = carNames;
        this.carNumber = carNames.size();
        this.tryCount = tryCount;
    }

    List<String> getCarNames() {
        return this.carNames;
    }

    int getCarNumber(){
        return this.carNumber;
    }

    int getTryCount() {
        return this.tryCount;
    }
}
