package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;

final class RacingCar {

    private static final String STOP = "";
    private static final String FORWARD = "-";

    private String name = null;
    private Integer tryCount = null;
    private MovementStrategy movementStrategy = null;
    private List<String> traces = null;

    private RacingCar(){
        this.tryCount = 0;
        this.movementStrategy = new RandomMovementStrategy();
        this.traces = new ArrayList<>();
        traces.add(STOP);
    }

    RacingCar(final int tryCount, final String name){
        this();
        this.tryCount = tryCount;
        this.name = name;
    }

    public void updateStrategy(MovementStrategy strategy){
        this.movementStrategy = strategy;
    }

    public int getTryCount(){
        return this.tryCount;
    }

    public List<String> getTraces(){
        return this.traces;
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
