package eu.deic.oop;

import java.util.Scanner;

public class ParkingPlace {
    private int[] parkingTimes;

    public ParkingPlace(int days) {
        this.parkingTimes = new int[days];
    }

    public void inputParkingTime(Scanner scanner, int placeIndex) {
        System.out.println("\n<!> Enter parking times for Parking Place " + (placeIndex + 1) + " <!>");

        for (int i = 0; i < parkingTimes.length; i++) {
            System.out.print("\tDay " + (i + 1) + ": ");
            this.parkingTimes[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    public int getMinTime() {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < this.parkingTimes.length; i++) {
            minTime = Math.min(minTime, this.parkingTimes[i]);
        }

        return minTime;
    }

    public int getMaxTime() {
        int maxTime = Integer.MIN_VALUE;

        for (int i = 0; i < this.parkingTimes.length; i++) {
            maxTime = Math.max(maxTime, this.parkingTimes[i]);
        }

        return maxTime;
    }

}
