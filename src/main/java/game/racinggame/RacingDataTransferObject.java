package game.racinggame;

public final class RacingDataTransferor {

    private int carNumber;
    private int tryCount;

    RacingDataTransferor(final int carNumber, final int tryCount){
        this.carNumber = carNumber;
        this.tryCount = tryCount;
    }

    public int getCarNumber(){
        return this.carNumber;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
