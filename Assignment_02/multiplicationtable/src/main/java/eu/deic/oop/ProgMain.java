package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {

    public static void printMultiplicationTable(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        System.out.print("Enter the size: ");
        size = Integer.parseInt(scanner.nextLine());

        scanner.close();

        System.out.println();
        printMultiplicationTable(size);
        System.out.println();
    }
}
