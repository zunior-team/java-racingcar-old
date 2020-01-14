public class Car {
    public static final int MOVE_DISTANCE = 1;
    private int position = 0;
    private int carNumber;

    private Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public static Car newInstance(int carNumber) {
        return new Car(carNumber);
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
