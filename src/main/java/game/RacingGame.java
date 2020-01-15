package game;

import car.Car;

public class RacingGame {

    private Car car;
    private RacingConsole console;

    private enum Status {
        START, QUIT
    }

    private RacingGame() {
        car = new Car();
        console = RacingConsole.create();
    }

    public static RacingGame create() {
        return new RacingGame();
    }

    public void start() {

        console.printGameStartMessage();

        while(true) {

            console.printAskCarNumberMessage();
            car.initRacingCarNumber(console.listen());

            console.printAskTryCountMessage();
            car.initRacingCarTryCount(console.listen());

            console.printGameResultMessage();

        }
    }
}
