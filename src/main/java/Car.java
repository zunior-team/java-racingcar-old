public class Car {
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

        this.position += 1;
    }
}
