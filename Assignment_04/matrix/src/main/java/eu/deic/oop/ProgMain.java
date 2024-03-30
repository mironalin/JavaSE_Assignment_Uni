package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(scanner);
        ui.start();
    }
}
