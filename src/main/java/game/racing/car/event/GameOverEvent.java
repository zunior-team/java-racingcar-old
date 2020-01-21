package game.racing.car.event;

import java.util.List;

public class GameOverEvent {
    private List<String> winners;

    public GameOverEvent(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
