package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private static final String COLON = " : ";
    private static final String STOP = "";
    private static final String FORWARD = "-";

    private String name = "";
    private Integer tryCount = 0;
    private MovementStrategy movementStrategy = new RandomMovementStrategy();
    private List<String> traces = null;

    private RacingCar(){
        this.traces = new ArrayList<String>(){{add(STOP);}};
    }

    RacingCar(final int tryCount, final String name){
        this();
        this.tryCount = tryCount;
        this.name = name;
    }

    RacingCar(final int tryCount, final String name, final MovementStrategy movementStrategy){
        this(tryCount, name);
        this.movementStrategy = movementStrategy;
    }

    static RacingCar createEmptyRacingCar(){
        return new RacingCar(0, "empty");
    }

    void updateRacingCar(final int tryCount, final String name, final MovementStrategy movementStrategy){
        this.tryCount = tryCount;
        this.name = name;
        this.movementStrategy = movementStrategy;
    }

    int getTryCount() {
        return tryCount;
    }

    String getName() {
        return name;
    }

    String getMyTracesByRound(final int round) {
        return name + COLON + traces.get(round);
    }

    int getMyLastTracesLength(){

        final int lastRound = traces.size() - 1;

        return traces.get(lastRound)
                .length();
    }

    void move(){

        StringBuilder road = new StringBuilder(STOP);

        for(int round = 1; round <= tryCount; round++) {
            road.append(moveByStrategy());
            traces.add(road.toString());
        }
    }

    private String moveByStrategy(){
        if(isMovable()){
            return FORWARD;
        }

        return STOP;
    }

    private boolean isMovable(){
        return (movementStrategy.getNumberByStrategy()
                >= RandomMovementStrategy.MOVBLE_STANDARD_NUMBER);
    }
}
