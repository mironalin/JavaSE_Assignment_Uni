package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of parking places: ");
        int n = Integer.parseInt(scanner.nextLine());

        final int days = 5;

        int[][] maxTimes = new int[n][];
        int[][] minTimes = new int[n][];

        for (int i = 0; i < n; i++) {
            maxTimes[i] = new int[days];
            minTimes[i] = new int[days];
            System.out.println("\n<!> Enter parking times for Parking Place " + (i + 1) + " <!>");
            for (int j = 0; j < days; j++) {
                System.out.print("\tDay " + (j + 1) + ": ");
                int time = Integer.parseInt(scanner.nextLine());
                maxTimes[i][j] = time;
                minTimes[i][j] = time;
            }
        }

        System.out.println("\n------------------------------------------------");

        for (int i = 0; i < n; i++) {
            int maxTime = Integer.MIN_VALUE;
            int minTime = Integer.MAX_VALUE;
            for (int j = 0; j < days; j++) {
                maxTime = Math.max(maxTime, maxTimes[i][j]);
                minTime = Math.min(minTime, minTimes[i][j]);
            }
            System.out.println("\n<!> Parking Place " + (i + 1) + " <!>");
            System.out.println("\tMax Time: " + maxTime + " minutes");
            System.out.println("\tMin Time: " + minTime + " minutes");
        }

        scanner.close();
    }
}
