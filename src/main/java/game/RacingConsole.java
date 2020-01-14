package game;

import java.util.Scanner;

import static constant.GameConsoleConstant.*;
import static java.lang.System.out;

public class RacingConsole  {

    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter gameStartPrinter;
    private ConsolePrinter gameQuitPrinter;
    private ConsolePrinter carNumberPrinter;
    private ConsolePrinter carTryCountPrinter;
    private ConsolePrinter resultPrinter;

    private RacingConsole() {
        this.gameStartPrinter = () -> out.println(GAME_START_PRINT);
        this.carNumberPrinter = () -> out.println(ASK_CAR_NUMBER_PRINT);
        this.carTryCountPrinter = () -> out.println(ASK_CAR_TRY_COUNT_PRINT);
        this.resultPrinter = () -> out.println(PROCESS_RESULT);
        this.gameQuitPrinter = () -> out.println(GAME_QUIT_PRINT);
    }

    public static RacingConsole create(){
        return new RacingConsole();
    }

    public int listen(){
        return Integer.parseInt(scanner.next());
    }

    public void printGameStartMessage(){
        gameStartPrinter.print();
    }

    public void printAskCarNumberMessage() {
        carNumberPrinter.print();
    }

    public void printAskTryCountMessage() {
        carTryCountPrinter.print();
    }

    public void printGameResultMessage() {
        resultPrinter.print();
    }

    public void printGameQuitMessage() {
        gameQuitPrinter.print();
    }
}
