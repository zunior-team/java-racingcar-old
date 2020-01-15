package game.racing.car.service.impl;

import game.racing.car.service.MovingStrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final Random random;
    private static final int RANDOM_INT_BOUNDED = 10;
    private static final int MIN_MOVABLE_RANDOM_NUMBER = 4;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    public RandomMovingStrategy() {
        this.random = new Random();
    }

    @Override
    public Boolean isMovable() {
        return random.nextInt(RANDOM_INT_BOUNDED) >= MIN_MOVABLE_RANDOM_NUMBER;
    }
}
