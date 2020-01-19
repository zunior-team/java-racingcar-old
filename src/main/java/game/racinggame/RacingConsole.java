package racinggame;

import game.InputDevice;
import game.OutputDevice;

public class RacingConsole implements InputDevice, OutputDevice {

    private static final String ASKING_CAR_NUMBER_PRINT =
    private RacingConsole(){}

    public RacingConsole create(){
        return new RacingConsole();
    }

    @Override
    public Object doInput() {

        return null;
    }

    @Override
    public void doPrint() {

    }
}
