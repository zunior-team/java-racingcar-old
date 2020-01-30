package game.racinggame;

import game.Game;
import game.racinggame.console.RacingInputDevice;
import game.racinggame.console.RacingOutputDevice;

public final class RacingGame implements Game {

    private final RacingCars racingCars;
    private final RacingInputDevice racingInputDevice;
    private final RacingOutputDevice racingOutputDevice;

    private RacingGame(){
        this.racingCars = new RacingCars();
        this.racingInputDevice = new RacingInputDevice();
        this.racingOutputDevice = new RacingOutputDevice();
    }

    public static RacingGame create() {
        return new RacingGame();
    }

    @Override
    public void start() {

        racingCars.setUpRacing(racingInputDevice.doInput());

        racingCars.go();

//        racingOutDevice.showResult(racingCars.getRacingCars());
    }
}
