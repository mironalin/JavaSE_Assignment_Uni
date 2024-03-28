package eu.deic.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgMain {

    public static double calculateIncomeTax(int income, int marginalTaxRate) {
        return Math.round(marginalTaxRate * 0.01 * income * 100) / 100.00;
    }

    public static int calculateMarginalTaxRate(int income, String filingStatus) {
        switch (filingStatus) {
            case "Single":
                if (income >= 372_951) {
                    // marginalTaxRate = 35;
                    return 35;
                } else if (income >= 171_551) {
                    return 33;
                } else if (income >= 82_251) {
                    return 28;
                } else if (income >= 33_951) {
                    return 25;
                } else if (income >= 8_351) {
                    return 15;
                } else {
                    return 10;
                }
            case "Married Filling Jointly or Qualified Widow(er)":
                if (income >= 372_951) {
                    // marginalTaxRate = 35;
                    return 35;
                } else if (income >= 208_851) {
                    return 33;
                } else if (income >= 137_051) {
                    return 28;
                } else if (income >= 67_901) {
                    return 25;
                } else if (income >= 16_071) {
                    return 15;
                } else {
                    return 10;
                }

            case "Married Filling Separately":
                if (income >= 186_476) {
                    // marginalTaxRate = 35;
                    return 35;
                } else if (income >= 104_426) {
                    return 33;
                } else if (income >= 68_525) {
                    return 28;
                } else if (income >= 33_951) {
                    return 25;
                } else if (income >= 8_351) {
                    return 15;
                } else {
                    return 10;
                }
            case "Head of Household":
                if (income >= 372_951) {
                    // marginalTaxRate = 35;
                    return 35;
                } else if (income >= 190_201) {
                    return 33;
                } else if (income >= 117_451) {
                    return 28;
                } else if (income >= 45_501) {
                    return 25;
                } else if (income >= 11_951) {
                    return 15;
                } else {
                    return 10;
                }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = -1;
        int selection = -1;
        String filingStatus;
        int marginalTaxRate;
        double incomeTax;
        List<String> statusList = new ArrayList<>();
        statusList.add("Single");
        statusList.add("Married Filling Jointly or Qualified Widow(er)");
        statusList.add("Married Filling Separately");
        statusList.add("Head of Household");

        while (true) {
            if (income >= 0) {
                break;
            }
            System.out.print("\nEnter income(integer): ");
            income = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("");

        System.out.println("Select filling status[0-3]:");
        for (int i = 0; i < statusList.size(); i++) {
            System.out.println(i + ": " + statusList.get(i));
        }

        while (true) {
            if (selection >= 0 && selection < 4) {
                filingStatus = statusList.get(selection);
                break;
            } else {
                System.out.print("Select a value from [0-3]: ");
                selection = Integer.valueOf(scanner.nextLine());
            }
        }

        scanner.close();

        marginalTaxRate = calculateMarginalTaxRate(income, filingStatus);
        incomeTax = calculateIncomeTax(income, marginalTaxRate);

        System.out.println("\n----------------------------------------------");
        System.out.println("Your filing status is: " + filingStatus);
        System.out.println("Your income is: $" + income);
        System.out.println("Your Marginal Tax Rate: " + marginalTaxRate + "%");
        System.out.println("Your personal income tax is: $" + incomeTax);
        System.out.println("----------------------------------------------");
    }
}
