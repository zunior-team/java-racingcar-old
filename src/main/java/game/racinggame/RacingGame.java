package game.racinggame;

import game.Game;
import game.InputDevice;
import game.OutputDevice;
import game.racinggame.console.RacingConsole;

public final class RacingGame implements Game {

    private final RacingCars racingCars;
    private final InputDevice racingInDevice;
    private final OutputDevice racingOutDevice;


    private RacingGame(){
        this.racingCars = new RacingCars();
        this.racingInDevice = new RacingConsole();
        this.racingOutDevice = new RacingConsole();
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
