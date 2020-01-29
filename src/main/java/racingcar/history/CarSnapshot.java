package racingcar.history;

import racingcar.racing.Car;

public class CarSnapshot {
    private String carName;
    private Integer position;

    public CarSnapshot(Car car) {
        this.carName = car.getName();
        this.position = car.currentPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
