package game.racing.car.event;

import java.util.List;

public class RoundOverEvent {
    private List<Integer> carPositions;

    public RoundOverEvent(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
