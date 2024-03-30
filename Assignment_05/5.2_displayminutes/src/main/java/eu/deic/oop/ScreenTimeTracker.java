package eu.deic.oop;

import java.util.Scanner;

public class ScreenTimeTracker {
    private int totalWeeks;
    private int daysPerWeek;
    private int minMinutes;
    private int maxMinutes;
    private int minDay;
    private int maxDay;

    public ScreenTimeTracker(int totalWeeks, int daysPerWeek) {
        this.totalWeeks = totalWeeks;
        this.daysPerWeek = daysPerWeek;
        this.minMinutes = Integer.MAX_VALUE;
        this.maxMinutes = Integer.MIN_VALUE;
        this.minDay = 0;
        this.maxDay = 0;
    }

    public void trackScreenTime(Scanner scanner) {
        for (int week = 0; week < totalWeeks; week++) {
            System.out.println("\n<> Week " + (week + 1) + " <>");
            for (int day = 0; day < daysPerWeek; day++) {
                System.out.print("Enter the minutes spent on day " + (day + 1) + ": ");
                int minutes = Integer.parseInt(scanner.nextLine());

                if (minutes < this.minMinutes) {
                    this.minMinutes = minutes;
                    this.minDay = week * this.daysPerWeek + (day + 1);
                }

                if (minutes > this.maxMinutes) {
                    this.maxMinutes = minutes;
                    this.maxDay = week * this.daysPerWeek + (day + 1);
                }
            }
        }
    }

    public void printScreenTime() {
        System.out.println("\n<> Minimum Screen Time <>");
        System.out.println("Day: " + this.minDay);
        System.out.println("Minutes: " + this.minMinutes);

        System.out.println("\n<> Maximum Screen Time <>");
        System.out.println("Day: " + this.maxDay);
        System.out.println("Minutes: " + this.maxMinutes);

        System.out.println();
    }
}
