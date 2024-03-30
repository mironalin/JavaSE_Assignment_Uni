package eu.deic.oop;

import java.util.Scanner;

public class ProgMainOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of parking places: ");
        int n = Integer.parseInt(scanner.nextLine());

        final int days = 5;

        ParkingPlaceStatistics parkingPlaceStatistics = new ParkingPlaceStatistics(n, days);

        parkingPlaceStatistics.inputDataForEachPPlace(scanner);

        parkingPlaceStatistics.printStatistics();

        scanner.close();
    }
}
