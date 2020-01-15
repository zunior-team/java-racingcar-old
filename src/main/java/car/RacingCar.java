package car;

import java.util.concurrent.ThreadLocalRandom;

import static constant.GameConstant.*;

public class RacingCar implements MovingStrategy{

    private int tryCount = 0;

    public void setupTryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    public String move() {
        if(isMovable()){
            return ROAD;
        }

        return _EMPTY;
    }

    private boolean isMovable() {
        if(getValueByRandomStrategy() >= MOVEMENT_STANDARD){
            return true;
        }

        return false;
    }

    @Override
    public int getValueByRandomStrategy() {
        return ThreadLocalRandom.current()
                .nextInt(0, 9);
    }
}
