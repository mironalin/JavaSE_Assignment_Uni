package eu.deic.oop;

import java.util.Scanner;

public class MarksCalculator {
    private int numberOfClasses;
    private int numberOfStudents;
    private int numberOfAssignments;
    private double[][][] marksArray;

    public MarksCalculator(int numberOfClasses, int numberOfStudents, int numberOfAssignments) {
        this.numberOfClasses = numberOfClasses;
        this.numberOfStudents = numberOfStudents;
        this.numberOfAssignments = numberOfAssignments;
        marksArray = new double[numberOfClasses][numberOfStudents][numberOfAssignments];
    }

    public void addMarks(Scanner scanner) {
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
    }

    public double[][] calculateStudentAverages() {
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

        return averagePerStudentArray;
    }

    public double[] calculateClassAverages() {
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

        return averagePerClassArray;
    }

    public double calculateTotalAverage() {
        double totalAverageForEntireYear = 0;

        for (int i = 0; i < this.numberOfClasses; i++) {
            totalAverageForEntireYear += calculateClassAverages()[i];
        }
        totalAverageForEntireYear /= numberOfClasses;
        totalAverageForEntireYear = Math.floor(totalAverageForEntireYear * 100) / 100.00;

        return totalAverageForEntireYear;
    }

    public void printMarks() {
        System.out.println("\n<!> Average Mark for Each Student <!>");
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.println("\n\t<> Class " + (classIndex + 1) + " <>");
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                System.out.println(
                        "\t\tStudent " + (studentIndex + 1) + ": "
                                + Math.floor(calculateStudentAverages()[classIndex][studentIndex] * 100) / 100.00);
            }
        }

        System.out.println("\n<!> Average Mark for Each Class <!>");
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.println("\n\tClass " + (classIndex + 1) + ": "
                    + Math.floor(calculateClassAverages()[classIndex] * 100) / 100.00);
        }

        System.out.println("\n<!> Total Average for the Entire Year <!>");
        System.out.println("\n\tAverage: " + calculateTotalAverage() + "\n");
    }
}
