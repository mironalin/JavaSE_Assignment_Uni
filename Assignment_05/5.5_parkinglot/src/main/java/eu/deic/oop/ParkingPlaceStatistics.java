package eu.deic.oop;

import java.util.Scanner;

public class ParkingPlaceStatistics {
    private ParkingPlace[] parkingPlaces;
    private int numberOfDays;

    public ParkingPlaceStatistics(int numberOfParkingPlaces, int numberOfDays) {
        this.parkingPlaces = new ParkingPlace[numberOfParkingPlaces];
        this.numberOfDays = numberOfDays;
    }

    public void inputDataForEachPPlace(Scanner scanner) {
        for (int i = 0; i < parkingPlaces.length; i++) {
            parkingPlaces[i] = new ParkingPlace(numberOfDays);
            parkingPlaces[i].inputParkingTime(scanner, i);
        }
    }

    public int maxTimeForEachPPlace(int index) {
        return parkingPlaces[index].getMaxTime();
    }

    public int minTimeForEachPPlace(int index) {
        return parkingPlaces[index].getMinTime();
    }

    public void printStatistics() {
        for (int i = 0; i < parkingPlaces.length; i++) {
            System.out.println("\n<!> Parking Place " + (i + 1) + " <!>");
            System.out.println("\tMax Time: " + maxTimeForEachPPlace(i) + " minutes");
            System.out.println("\tMin Time: " + minTimeForEachPPlace(i) + " minutes");
        }
    }
}
