package eu.deic.oop;

import java.util.Scanner;

public class ProgMainOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of classes: ");
        int numberOfClasses = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of students per class: ");
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of assignments: ");
        int numberOfAssignments = Integer.parseInt(scanner.nextLine());

        MarksCalculator marksCalculator = new MarksCalculator(numberOfClasses, numberOfStudents, numberOfAssignments);
        marksCalculator.addMarks(scanner);

        marksCalculator.printMarks();
    }
}
