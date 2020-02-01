package game.racinggame.console;

import game.racinggame.RacingTracer;
import game.racinggame.RacingTracerResultDevice;

public class RacingOutputDevice {

    public void showResult(final RacingTracer racingTracer) {

        final RacingTracerResultDevice result = racingTracer.createRacingTracerResult();

        System.out.println();
        System.out.println("실행결과");
        System.out.println(result.getCarTraces());
        System.out.println();
        System.out.println(result.getRacingWinners());
    }
}
