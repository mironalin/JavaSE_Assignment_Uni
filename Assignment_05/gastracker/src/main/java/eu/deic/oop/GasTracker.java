package eu.deic.oop;

import java.util.Scanner;

public class GasTracker {
    private int days;
    private double totalLiters;
    private double totalMoney;

    public GasTracker(int days) {
        this.days = days;
        this.totalLiters = 0;
        this.totalMoney = 0;
    }

    public double getTotalLiters() {
        return totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getAverageLiters() {
        return totalLiters / days;
    }

    public double getAverageMoney() {
        return totalMoney / days;
    }

    public void trackGasConsumption(Scanner scanner) {
        for (int i = 0; i < days; i++) {
            System.out.println("\n<> Day " + (i + 1) + " <>");
            System.out.print("Enter the amount of gas consumed(liters): ");
            double liters = scanner.nextDouble();
            totalLiters += liters;

            System.out.print("Enter the money spent per liter(RON): ");
            double moneyPerLiter = scanner.nextDouble();
            totalMoney += liters * moneyPerLiter;
        }
    }

    public void printGasConsumption() {
        System.out.println("\n<> Overall Gas Consumption <>");
        System.out.println("Total liters: " + getTotalLiters());
        System.out.println("Total money spent: " + getTotalMoney());
        System.out.println("\n<> Average Gas Consumption <>");
        System.out.println("Average liters per day: " + getAverageLiters());
        System.out.println("Average money spent per day: " + getAverageMoney());
        System.out.println();
    }

}
