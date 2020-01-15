package racingcar.dto;

public class RacingCarInput {
    private int numberOfCar;
    private int numberOfRound;

    public RacingCarInput(int numberOfCar, int numberOfRound) {
        this.numberOfCar = numberOfCar;
        this.numberOfRound = numberOfRound;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
