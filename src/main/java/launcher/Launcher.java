package launcher;

import game.racinggame.RacingGame;

public class Launcher {

    public static void main(String[]args) {

        RacingGame racingGame = RacingGame.create();
        racingGame.start();
    }
}
