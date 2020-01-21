package game.racing.car.model;

import game.racing.car.service.MovingStrategy;

public class Car {
    private String carName;
    private Integer position;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.position = 0;
        this.movingStrategy = movingStrategy;
    }

    public Car(String carName, Integer currentPosition, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.position = currentPosition;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public String getCarName() {
        // 이걸 어떻게 한담...
        return carName;
    }

    public Integer getPosition() {
        // 이걸 어떻게 한담...
        return position;
    }
}
