package game.racing.car.model;

import game.racing.car.model.vo.CarDto;
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

    public CarDto makeCarDto() {
        return new CarDto(carName, position);
    }
}
