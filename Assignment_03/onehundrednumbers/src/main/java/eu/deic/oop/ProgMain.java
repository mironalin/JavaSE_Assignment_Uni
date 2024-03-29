package eu.deic.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProgMain {

    public static void generateOneHundredNumbers(int range, List<Integer> numbersList) {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            numbersList.add(random.nextInt(range));
        }
    }

    public static double calculateAverage(List<Integer> numbersList) {
        return numbersList.stream().mapToInt(number -> number).average().orElse(0.0);
    }

    public static int aboveAverage(List<Integer> numbersList, double average) {
        int aboveAverage = 0;

        for (int number : numbersList) {
            if (number > average) {
                aboveAverage++;
            }
        }

        return aboveAverage;
    }

    public static void printDetails(List<Integer> numbersList, double average, int aboveAverage) {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("The numbers:\n");
        for (int i = 0; i < numbersList.size(); i++) {
            if (i == 20 || i == 40 || i == 60 || i == 80) {
                System.out.println();
            }
            System.out.printf("%4d", numbersList.get(i));
        }
        System.out.println();
        System.out.println("\nThe average: " + average);
        System.out.println("\nNumbers above average: " + aboveAverage);
        System.out.println("------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        List<Integer> numbersList = new ArrayList<>();

        generateOneHundredNumbers(100, numbersList);

        double average = calculateAverage(numbersList);
        int aboveAverage = aboveAverage(numbersList, average);

        printDetails(numbersList, average, aboveAverage);

    }
}
