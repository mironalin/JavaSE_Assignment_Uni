package eu.deic.oop;

import java.util.Scanner;

public class ProgMainOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days;
        System.out.print("\nEnter the number of days: ");
        days = Integer.parseInt(scanner.nextLine());

        GasTracker gasTracker = new GasTracker(days);

        gasTracker.trackGasConsumption(scanner);
        gasTracker.printGasConsumption();

        scanner.close();
    }
}
