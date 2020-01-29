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

    public String showRoundHistory() {
        StringBuilder roundHistory = new StringBuilder();

        for(CarSnapshot snapshot : carSnapshots) {
            roundHistory.append(snapshot.showCarSnapShot())
                    .append('\n');
        }

        return roundHistory.toString();
    }
}
