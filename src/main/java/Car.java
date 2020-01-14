public class Car {
    public static final int MOVE_DISTANCE = 1;
    private int position = 0;

    public static Car newInstance() {
        return new Car();
    }

    public int currentPosition() {
        return this.position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (!movingStrategy.check()) {
            return;
        }

        this.position += MOVE_DISTANCE;
    }
}
