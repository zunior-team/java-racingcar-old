package game.racinggame;

import game.Game;
import game.InputDevice;
import game.OutputDevice;

public final class RacingGame implements Game {

    private final RacingCars racingCars;
    private final InputDevice racingInDevice;
    private final OutputDevice racingOutDevice;

    private RacingGame(){
        racingCars = new RacingCars();
        racingInDevice = new RacingConsole();
        racingOutDevice = new RacingConsole();
    }

    public static RacingGame create() {
        return new RacingGame();
    }

    @Override
    public void start() {

        racingCars.setUpRacing(racingInDevice.doInput());

        racingCars.go();

        racingOutDevice.showResult(racingCars.getTraces());
    }
}
