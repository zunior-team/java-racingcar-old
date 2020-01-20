package racingcar.racing;

import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.Random;
import java.util.stream.IntStream;

public class Car {
    public static final String DASH_MARK = "-";

    private String name;
    private Integer position = 0;
    private MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, new RandomMoveStrategy(new Random()));
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public int move() {
        if(moveStrategy.isMovable()) {
            position++;
        }

        return position;
    }

    public String printPosition() {
        StringBuilder stringBuilder = new StringBuilder(this.name + " : ");

        IntStream.rangeClosed(0, position)
                .forEach(x -> stringBuilder.append(DASH_MARK));

        return stringBuilder.toString();
    }
}
