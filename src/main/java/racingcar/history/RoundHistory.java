package racingcar.history;

import java.util.List;

public class RoundHistory {
    private List<CarSnapshot> carSnapshots;

    public RoundHistory(List<CarSnapshot> carSnapshots) {
        if(carSnapshots == null) {
            throw new IllegalArgumentException("Car snapshot must not be a null");
        }

        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
