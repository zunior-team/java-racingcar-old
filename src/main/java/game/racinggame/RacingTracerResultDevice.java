package game.racinggame;

public class RacingTracerResultDevice {

    private final RacingTracer tracer;

    RacingTracerResultDevice(final RacingTracer tracer){
        this.tracer = tracer;
    }

    public String getCarTraces() {
        return tracer.getTraces();
    }

    public String getRacingWinners() {
        return tracer.getWinners() + "가 최종우승 했습니다.";
    }
}