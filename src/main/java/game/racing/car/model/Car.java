package game.racing.car.model;

import game.racing.car.service.MovingStrategy;

public class Car {
    private Integer position;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.position = 0;
        this.movingStrategy = movingStrategy;
    }

    public Car(Integer currentPosition, MovingStrategy movingStrategy) {
        this.position = currentPosition;
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
