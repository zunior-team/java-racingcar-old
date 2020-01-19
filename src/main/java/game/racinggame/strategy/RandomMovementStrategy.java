package game.racinggame.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMovementStrategy implements MovementStrategy {

    public static final int MOVBLE_STANDARD_NUMBER = 4;
    private static final int INCLUDE_FROM_NUMBER = 0;
    private static final int EXCLUDE_TO_NUMBER = 10;

    @Override
    public int getNumberByStrategy() {
        return ThreadLocalRandom.current()
                .nextInt(INCLUDE_FROM_NUMBER, EXCLUDE_TO_NUMBER);
    }
}
