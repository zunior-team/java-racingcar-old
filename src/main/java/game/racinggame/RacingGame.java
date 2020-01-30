package game.racinggame;

import game.Game;
import game.InputDevice;
import game.OutputDevice;
import game.racinggame.console.RacingConsole;
import game.racinggame.console.RacingInputDevice;

public final class RacingGame implements Game {

    private final RacingCars racingCars;
    private final OutputDevice racingOutDevice;
    private final RacingInputDevice racingInputDevice;

    private RacingGame(){
        this.racingCars = new RacingCars();
        this.racingOutDevice = new RacingConsole();
        this.racingInputDevice = new RacingInputDevice();
    }

    public static RacingGame create() {
        return new RacingGame();
    }

    @Override
    public void start() {

        racingCars.setUpRacing(racingInputDevice.doInput());

        racingCars.go();

        racingOutDevice.showResult(racingCars.getRacingCars());
    }
}
