package view;

import car.Car;
import game.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String COMMA = ",";

    private OutputView() {

    }

    public static void print(RacingGame racingGame) {
        int lap = 1;
        while (!racingGame.isDone()) {
            System.out.println("###########   " + lap++ +" LAP 의 결과는 ?! ########");
            printTracks(racingGame.proceedAndGetTrack());

            System.out.println("===============================================\n");
        }

        printWinner(racingGame.getWinner());


    }

    private static void printWinner(List<Car> winner) {
        final String winners = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));
        System.out.println("승자는  # "+winners + " # 축하합니다~");
    }

    private static void printTracks(List<String> tracks) {
        for (String track : tracks) {
            System.out.println(track);
        }
    }


}



