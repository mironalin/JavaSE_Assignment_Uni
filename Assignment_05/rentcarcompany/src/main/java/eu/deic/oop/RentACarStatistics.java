package eu.deic.oop;

import java.util.Scanner;

public class RentACarStatistics {
    private int numberOfCars;
    private int numberOfDays;
    private Car[] cars;

    public RentACarStatistics(int numberOfCars, int numberOfDays) {
        this.numberOfCars = numberOfCars;
        this.numberOfDays = numberOfDays;
        cars = new Car[numberOfCars];
    }

    public void inputKmForEachCar(Scanner scanner) {
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            this.cars[carIndex] = new Car(numberOfDays);
            this.cars[carIndex].inputKilometers(scanner, carIndex);
        }
    }

    public void printAvgKm() {
        System.out.println("\n<!> Average Kilometers per Day for Each Car <!>");
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            System.out.println("\tCar " + (carIndex + 1) + ": "
                    + Math.floor(this.cars[carIndex].calculateAverage() * 100) / 100.00);
        }
    }

    public void printMaxKms() {
        System.out.println("\n<!> Maximum kilometers per Day for Each Car <!>");
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            System.out.println(
                    "\tCar " + (carIndex + 1) + ": " + Math.floor(cars[carIndex].calculateMaxKms() * 100) / 100.00);
        }
    }

    public void printMinKms() {
        System.out.println("\n<!> Minimum kilometers per Day for Each Car <!>");
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            System.out.println(
                    "\tCar " + (carIndex + 1) + ": " + Math.floor(cars[carIndex].calculateMinKms() * 100) / 100.00);
        }
    }

    public void printStatistics() {
        System.out.println("\n----------------------------------------------------");

        printAvgKm();
        printMaxKms();
        printMinKms();
    }
}
