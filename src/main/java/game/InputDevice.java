package game;

import java.util.Scanner;

public interface InputDevice {

    Scanner scanner = new Scanner(System.in);

    Object doInput();

}
