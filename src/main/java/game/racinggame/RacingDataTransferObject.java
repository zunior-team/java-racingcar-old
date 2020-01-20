package game.racinggame;

public final class RacingDataTransferObject {

    private int carNumber;
    private int tryCount;

    public RacingDataTransferObject(final int carNumber, final int tryCount){
        this.carNumber = carNumber;
        this.tryCount = tryCount;
    }

    int getCarNumber(){
        return this.carNumber;
    }

    int getTryCount() {
        return this.tryCount;
    }
}
