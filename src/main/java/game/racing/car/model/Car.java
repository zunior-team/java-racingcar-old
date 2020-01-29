package game.racing.car.model;

import game.racing.car.model.dto.CarPosition;
import game.racing.car.service.MovingStrategy;

public class Car {
    private String carName;
    private Integer location;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this(carName, 0, movingStrategy);
    }

    public Car(String carName, Integer currentPosition, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.location = currentPosition;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.isMovable()) {
            location++;
        }
    }

    public CarPosition getCarPosition() {
        return new CarPosition(carName, location);
    }
}
