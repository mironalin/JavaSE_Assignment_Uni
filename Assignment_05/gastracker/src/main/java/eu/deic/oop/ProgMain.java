package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days;
        System.out.print("\nEnter the number of days: ");
        days = Integer.parseInt(scanner.nextLine());

        double totalLiters = 0;
        double totalMoney = 0;

        for (int i = 0; i < days; i++) {
            System.out.println("\n<> Day " + (i + 1) + " <>");
            System.out.print("Enter the amount of gas consumed(liters): ");
            double liters = scanner.nextDouble();
            totalLiters += liters;

            System.out.print("Enter the money spent per liter(RON): ");
            double moneyPerLiter = scanner.nextDouble();
            totalMoney += liters * moneyPerLiter;
        }

        double averageLiters = totalLiters / days;
        double averageMoney = totalMoney / days;

        System.out.println("\n<> Overall Gas Consumption <>");
        System.out.println("Total liters: " + totalLiters);
        System.out.println("Total money spent: " + totalMoney);
        System.out.println("\n<> Average Gas Consumption <>");
        System.out.println("Average liters per day: " + averageLiters);
        System.out.println("Average money spent per day: " + averageMoney);
        System.out.println();
    }
}
