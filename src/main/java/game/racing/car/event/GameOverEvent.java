package game.racing.car.event;

import game.racing.car.model.vo.CarPosition;

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
