package eu.deic.oop;

import java.util.Scanner;

public class ProgMainOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of weeks: ");
        int weeks = Integer.parseInt(scanner.nextLine());

        ScreenTimeTracker screenTimeTracker = new ScreenTimeTracker(weeks, 7);
        screenTimeTracker.trackScreenTime(scanner);
        screenTimeTracker.printScreenTime();

        scanner.close();
    }
}
