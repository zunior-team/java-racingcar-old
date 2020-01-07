package game.racing.car.service.impl;

import game.racing.car.service.MovingStrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private Random random;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public Boolean isMovable() {
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(10) >= 4;
    }
}
