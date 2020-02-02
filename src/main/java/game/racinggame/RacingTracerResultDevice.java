package game.racinggame;

import java.util.List;
import java.util.StringJoiner;

public class RacingTracerResultDevice {

    private static final String COMMA = ", ";
    private final RacingTracer tracer;

    RacingTracerResultDevice(final RacingTracer tracer){
        this.tracer = tracer;
    }

    public String getCarTraces() {
        return tracer.getTraces();
    }

    public String getRacingWinners() {
        return winnerToString(tracer.getWinners()) + "가 최종우승 했습니다.";
    }

    private String winnerToString(final List<String> winners){

        final StringJoiner joiner = new StringJoiner(COMMA);

        winners.forEach(joiner::add);

        return joiner.toString();
    }
}