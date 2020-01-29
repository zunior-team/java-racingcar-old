package game.racing.car.model.dto;

/**
 * Car 객체의 이름과 위치만 전달하는 DTO
 */
public class CarPosition {
    private final String carName;
    private final Integer location;

    public CarPosition(String carName, Integer location) {
        this.carName = carName;
        this.location = location;
    }

    public String getCarName() {
        return this.carName;
    }

    public Integer getLocation() {
        return this.location;
    }
}
