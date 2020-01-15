package racingcar;

import java.util.Random;
import java.util.stream.IntStream;

public class Car {
    public static final String DASH_MARK = "-";

    private Integer position = 0;
    private MoveStrategy moveStrategy;

    Car() {
        this.moveStrategy = new RandomMoveStrategy(new Random());
    }

    Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if(moveStrategy.isMovable()) {
            position++;
        }
    }

    public String printPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.rangeClosed(0, position)
                .forEach(x -> stringBuilder.append(DASH_MARK));

        return stringBuilder.toString();
    }
}
