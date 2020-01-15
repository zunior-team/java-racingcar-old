package car;

import strategy.MovingStrategy;

public class Car {
    public static final int MOVE_DISTANCE = 1;
    public static final String PATH_MARK = "-";
    public static final String START_LINE = "|";
    private int position = 0;
    private int carNumber;

    private Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public static Car newInstance(int carNumber) {
        return new Car(carNumber);
    }

    public String getHistory() {
        StringBuilder history = new StringBuilder(START_LINE);
        for (int i = 0; i < position; i++) {
            history.append(PATH_MARK);
        }
        return history.toString();
    }

    public void move(MovingStrategy movingStrategy) {
        if (!movingStrategy.check()) {
            return;
        }

        this.position += MOVE_DISTANCE;
    }
}
