package racingcar.history;

import racingcar.racing.Car;
import spark.utils.StringUtils;

import java.util.Objects;

public class CarSnapshot {
    private String carName;
    private Integer position;

    public CarSnapshot(Car car) {
        this.carName = car.getName();
        this.position = car.currentPosition();
    }

    public CarSnapshot(String name, int position) {
        if(StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name is must not null");
        }

        this.carName = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSnapshot that = (CarSnapshot) o;
        return Objects.equals(carName, that.carName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
