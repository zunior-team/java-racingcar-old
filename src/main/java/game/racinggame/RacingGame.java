package game.racinggame;

import game.Game;
import game.InputDevice;
import game.OutputDevice;

public final class RacingGame implements Game {

    private final RacingCars racingCars;

    private InputDevice racingInDevice;
    private OutputDevice racingOutDevice;

    private RacingGame(){
        racingCars = new RacingCars();
    }

    private RacingGame(final InputDevice inputDevice, final OutputDevice outputDevice){
        this();
        this.racingInDevice = inputDevice;
        this.racingOutDevice = outputDevice;
    }

    public static RacingGame create(final InputDevice inputDevice, final OutputDevice outputDevice) {
        return new RacingGame(inputDevice, outputDevice);
    }

    @Override
    public void start() {

        racingCars.setUpRacing(racingInDevice.doInput());

        racingCars.go();

        racingOutDevice.showResult(racingCars.getTraces());
    }
}
