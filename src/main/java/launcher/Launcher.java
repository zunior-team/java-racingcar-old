package launcher;

import game.racinggame.RacingGame;
import game.racinggame.console.RacingNameConsole;

public class Launcher {

    public static void main(String[]args) {

        RacingGame racingGame = RacingGame.create(
                new RacingNameConsole(),
                new RacingNameConsole());

        racingGame.start();
    }
}
