package car;

import strategy.MovingStrategy;

public class Car {
    public static final int MOVE_DISTANCE = 1;
    public static final String PATH_MARK = "-";
    public static final String START_LINE = "|";
    private int position = 0;
    private String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car newInstance(String name) {
        return new Car(name);
    }

    public String getTrack() {
        StringBuilder track = new StringBuilder(START_LINE);
        for (int i = 0; i < position; i++) {
            track.append(PATH_MARK);
        }
        return track.toString();
    }

    public void move(MovingStrategy movingStrategy) {
        if (!movingStrategy.isMovable()) {
            return;
        }

        this.position += MOVE_DISTANCE;
    }
}
