package game.racinggame.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy{

    private static final int INCLUDE_FROM_NUMBER = 0;
    private static final int EXCLUDE_TO_NUBER = 10;

    @Override
    public boolean movementStrategy() {
        return ThreadLocalRandom.current()
                .nextInt(INCLUDE_FROM_NUMBER, EXCLUDE_TO_NUBER);
    }
}
