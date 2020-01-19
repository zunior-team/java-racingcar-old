package game.racinggame;

import game.racinggame.strategy.MovementStrategy;
import game.racinggame.strategy.RandomMovementStrategy;

import java.util.ArrayList;
import java.util.List;

final class RacingCar {

    private static final String NONE_DISTANCE = "";
    private static final String ONE_DISTANCE = "-";

    private Integer tryCount = null;
    private MovementStrategy movementStrategy = null;
    private List<String> traces = null;

    private RacingCar(){
        this.tryCount = 0;
        this.movementStrategy = new RandomMovementStrategy();
        this.traces = new ArrayList<>();
        traces.add(NONE_DISTANCE);
    }

    RacingCar(final int tryCount){
        this();
        this.tryCount = tryCount;
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

        StringBuilder road = new StringBuilder(NONE_DISTANCE);

        for(int iTry = 1; iTry <= tryCount; iTry++) {
            road.append(moveByStrategy());
            traces.add(road.toString());
        }
    }

    private String moveByStrategy(){
        if(isMovable()){
            return ONE_DISTANCE;
        }

        return NONE_DISTANCE;
    }

    private boolean isMovable(){
        return (movementStrategy.getNumberByStrategy()
                >= RandomMovementStrategy.MOVBLE_STANDARD_NUMBER);
    }
}
