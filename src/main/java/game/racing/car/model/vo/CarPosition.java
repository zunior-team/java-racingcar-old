package game.racing.car.model.vo;

/**
 * Car 객체의 이름과 위치만 전달하는 DTO
 */
public class CarPosition {
    private final String carName;
    private final Integer position;

    public CarPosition(String carName, Integer position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return this.carName;
    }

    public Integer getPosition() {
        return this.position;
    }
}
