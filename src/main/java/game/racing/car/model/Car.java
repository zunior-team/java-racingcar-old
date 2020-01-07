package game.racing.car.model;

import game.racing.car.service.MovingStrategy;

public class Car {
    private Integer position = 0;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public Integer getPosition() {
        return position;
    }
}
