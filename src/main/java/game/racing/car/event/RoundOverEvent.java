package game.racing.car.event;

import game.racing.car.model.dto.CarPosition;

import java.util.List;

public class RoundOverEvent {
    private List<CarPosition> carPositions;

    public RoundOverEvent(List<CarPosition> carPositions) {
        this.carPositions = carPositions;
    }

    public List<CarPosition> getCarPositions() {
        return carPositions;
    }
}
