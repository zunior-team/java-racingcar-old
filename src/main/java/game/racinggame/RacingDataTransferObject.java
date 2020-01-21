package game.racinggame;

import java.util.List;

public final class RacingDataTransferObject {

    private List<String> carNames;
    private int carNumber;
    private int tryCount;

    public RacingDataTransferObject(final List<String> carNames, final int tryCount){
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
