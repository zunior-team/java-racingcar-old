package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int NUMBER_LIMIT = 10;
    public static final int MOVE_CRITERIA = 4;

    private Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(NUMBER_LIMIT) >= MOVE_CRITERIA;
    }
}
