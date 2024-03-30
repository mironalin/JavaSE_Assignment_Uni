package eu.deic.oop;

import java.util.Scanner;

public class Car {
    private int numberOfDays;
    private double[] kilometers;

    public Car(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        this.kilometers = new double[numberOfDays];
    }

    public void inputKilometers(Scanner scanner, int carIndex) {
        System.out.println("\n<!> Enter kilometers for Car " + (carIndex + 1) + " <!>");
        for (int day = 0; day < numberOfDays; day++) {
            System.out.print("\tDay " + (day + 1) + ": ");
            kilometers[day] = scanner.nextDouble();
        }
    }

    public double calculateAverage() {
        double total = 0;

        for (int i = 0; i < this.kilometers.length; i++) {
            total += this.kilometers[i];
        }

        return total / numberOfDays;
    }

    public double calculateMaxKms() {
        double maxKms = Double.MIN_VALUE;

        for (int i = 0; i < this.kilometers.length; i++) {
            maxKms = Math.max(maxKms, this.kilometers[i]);
        }

        return maxKms;

    }

    public double calculateMinKms() {
        double minKms = Double.MAX_VALUE;

        for (int i = 0; i < this.kilometers.length; i++) {
            minKms = Math.min(minKms, this.kilometers[i]);
        }

        return minKms;
    }

}
