package eu.deic.oop;

import java.util.Scanner;

public class ProgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of classes: ");
        int numberOfClasses = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of students per class: ");
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of assignments: ");
        int numberOfAssignments = Integer.parseInt(scanner.nextLine());

        double[][][] marksArray = new double[numberOfClasses][numberOfStudents][numberOfAssignments];

        // Input
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.println("\n<!> Enter marks for class " + (classIndex + 1) + " <!>");
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                System.out.println("\n\t<> For Student " + (studentIndex + 1) + " <>");
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    System.out.print("\t\tEnter mark for assignment " + (assignmentIndex + 1) + ": ");
                    marksArray[classIndex][studentIndex][assignmentIndex] = scanner.nextDouble();
                }
            }
        }

        double[][] averagePerStudentArray = new double[numberOfClasses][numberOfStudents];
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                double studentTotalMarks = 0;
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    studentTotalMarks += marksArray[classIndex][studentIndex][assignmentIndex];
                }
                averagePerStudentArray[classIndex][studentIndex] = studentTotalMarks / numberOfAssignments;
            }
        }

        double[] averagePerClassArray = new double[numberOfClasses];
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            double classTotalMarks = 0;
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    classTotalMarks += marksArray[classIndex][studentIndex][assignmentIndex];
                }
            }
            averagePerClassArray[classIndex] = classTotalMarks / (numberOfStudents * numberOfAssignments);
        }

        double totalAverageForEntireYear = 0;
        for (int i = 0; i < averagePerClassArray.length; i++) {
            totalAverageForEntireYear += averagePerClassArray[i];
        }
        totalAverageForEntireYear /= numberOfClasses;
        totalAverageForEntireYear = Math.floor(totalAverageForEntireYear * 100) / 100.00;

        // Printing
        System.out.println("\n<!> Average Mark for Each Student <!>");
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.println("\n\t<> Class " + (classIndex + 1) + " <>");
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                System.out.println(
                        "\t\tStudent " + (studentIndex + 1) + ": "
                                + Math.floor(averagePerStudentArray[classIndex][studentIndex] * 100) / 100.00);
            }
        }

        System.out.println("\n<!> Average Mark for Each Class <!>");
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.println("\n\tClass " + (classIndex + 1) + ": "
                    + Math.floor(averagePerClassArray[classIndex] * 100) / 100.00);
        }

        System.out.println("\n<!> Total Average for the Entire Year <!>");
        System.out.println("\n\tAverage: " + totalAverageForEntireYear + "\n");
        scanner.close();
    }
}
