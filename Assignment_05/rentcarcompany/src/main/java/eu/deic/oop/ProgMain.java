package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of cars: ");
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of days: ");
        int numberOfDays = Integer.parseInt(scanner.nextLine());

        double[][] kilometers = new double[numberOfCars][numberOfDays];

        for (int car = 0; car < numberOfCars; car++) {
            System.out.println("\n<!> Enter kilometers for Car " + (car + 1) + " <!>");
            for (int day = 0; day < numberOfDays; day++) {
                System.out.print("\tDay " + (day + 1) + ": ");
                kilometers[car][day] = scanner.nextDouble();
            }
        }

        double[] averagesCar = new double[numberOfCars];
        double[] maxKms = new double[numberOfCars];
        double[] minKms = new double[numberOfCars];

        for (int car = 0; car < numberOfCars; car++) {
            double total = 0;
            maxKms[car] = Double.MIN_VALUE;
            minKms[car] = Double.MAX_VALUE;

            for (int day = 0; day < numberOfDays; day++) {
                total += kilometers[car][day];
                maxKms[car] = Math.max(maxKms[car], kilometers[car][day]);
                minKms[car] = Math.min(minKms[car], kilometers[car][day]);
            }

            averagesCar[car] = total / numberOfDays;
        }

        // Print
        System.out.println("\n----------------------------------------------------");

        System.out.println("\n<!> Average Kilometers per Day for Each Car <!>");
        for (int car = 0; car < numberOfCars; car++) {
            System.out.println("\tCar " + (car + 1) + ": " + Math.floor(averagesCar[car] * 100) / 100.00);
        }

        System.out.println("\n<!> Maximum kilometers per Day for Each Car <!>");
        for (int car = 0; car < numberOfCars; car++) {
            System.out.println("\tCar " + (car + 1) + ": " + Math.floor(maxKms[car] * 100) / 100.00);
        }

        System.out.println("\n<!> Minimum kilometers per Day for Each Car <!>");
        for (int car = 0; car < numberOfCars; car++) {
            System.out.println("\tCar " + (car + 1) + ": " + Math.floor(minKms[car] * 100) / 100.00);
        }
    }
}
