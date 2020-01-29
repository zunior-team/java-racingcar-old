package game.racing.car.event;

import java.util.List;

public class GameOverEvent {
    private List<String> winners;

    public GameOverEvent(List<String> winners) {
        if(winners.isEmpty()) {
            throw new RuntimeException("There must be at least one winner.");
        }

        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
