package eu.deic.oop;

import java.util.Scanner;

public class ProgMainOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of cars: ");
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of days: ");
        int numberOfDays = Integer.parseInt(scanner.nextLine());

        RentACarStatistics rentACarStatistics = new RentACarStatistics(numberOfCars, numberOfDays);

        rentACarStatistics.inputKmForEachCar(scanner);

        rentACarStatistics.printStatistics();
        scanner.close();
    }
}
