package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int totalWeeks = 3;
        final int daysPerWeek = 7;

        int minMinutes = Integer.MAX_VALUE;
        int maxMinutes = Integer.MIN_VALUE;

        int minDay = 0;
        int maxDay = 0;

        for (int week = 0; week < totalWeeks; week++) {
            System.out.println("\n<> Week " + (week + 1) + " <>");
            for (int day = 0; day < daysPerWeek; day++) {
                System.out.print("Enter the minutes spent on day " + (day + 1) + ": ");
                int minutes = Integer.parseInt(scanner.nextLine());

                if (minutes < minMinutes) {
                    minMinutes = minutes;
                    minDay = week * daysPerWeek + (day + 1);
                }

                if (minutes > maxMinutes) {
                    maxMinutes = minutes;
                    maxDay = week * daysPerWeek + (day + 1);
                }
            }
        }

        System.out.println("\n<> Minimum Screen Time <>");
        System.out.println("Day: " + minDay);
        System.out.println("Minutes: " + minMinutes);

        System.out.println("\n<> Maximum Screen Time <>");
        System.out.println("Day: " + maxDay);
        System.out.println("Minutes: " + maxMinutes);

        System.out.println();
        scanner.close();
    }
}
