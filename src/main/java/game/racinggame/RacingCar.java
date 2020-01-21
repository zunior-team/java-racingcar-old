package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RacingCar {

    private static final String COLON = " : ";
    private static final String STOP = "";
    private static final String FORWARD = "-";

    private String name = null;
    private Integer tryCount = null;
    private MovementStrategy movementStrategy = null;
    private List<String> traces = null;

    private RacingCar(){
        this.tryCount = 0;
        this.traces = new ArrayList<>();
        traces.add(STOP);
    }

    RacingCar(final int tryCount, final String name, final RandomMovementStrategy movementStrategy){
        this();
        this.movementStrategy = movementStrategy;
        this.tryCount = tryCount;
        this.name = name;
    }

    public void updateStrategy(MovementStrategy strategy){
        this.movementStrategy = strategy;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getMyTracesByRound(final int round) {
        return name + COLON + traces.get(round);
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
