package eu.deic.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Matrix> matrixList;
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        matrixList = new ArrayList<>();
        this.scanner = scanner;
    }

    private Matrix populateMatrix(int rows, int columns) {
        Matrix matrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position(" + (i + 1) + ", " + (j + 1) + "): ");
                int value = Integer.parseInt(scanner.nextLine());
                matrix.setMatrixData(i, j, value);
            }
        }

        return matrix;
    }

    private Matrix createMatrixInterface(String matrix) {
        System.out.println("!<>! Enter " + matrix + " matrix dimensions !<>!\n");
        System.out.print("Rows: ");
        int matrixRows = Integer.parseInt(scanner.nextLine());
        System.out.print("Columns: ");
        int matrixColumns = Integer.parseInt(scanner.nextLine());

        System.out.println("\n<> Enter " + matrix + " matrix elements <>\n");
        Matrix matrixObject = populateMatrix(matrixRows, matrixColumns);

        return matrixObject;
    }

    private void printMatrixes(Matrix firstMatrix, Matrix secondMatrix) {
        System.out.println("!<>! Printing the matrixes !<>!");
        System.out.println();

        System.out.println("<> First Matrix(1) <>\n");
        firstMatrix.print();

        System.out.println();

        System.out.println("<> Second Matrix(2) <>\n");
        secondMatrix.print();
    }

    public void performOperations(Matrix firstMatrix, Matrix secondMatrix) {
        boolean continueOperations = true;

        System.out.println("-------------------Matrix Operations-------------------\n");

        while (continueOperations) {
            System.out.println("<> 1. Addition <>");
            System.out.println("<> 2. Subtraction <>");
            System.out.println("<> 3. Multiplication <>");
            System.out.println("<> 4. Scalar Multiplication <>");
            System.out.println("<> 5. Exit <>");

            System.out.print("\nEnter your choice[1-5]: ");
            int input = Integer.parseInt(scanner.nextLine());

            while (input < 1 || input > 5) {
                System.out.print("Invalid choice, try again[1-5]: ");
                input = Integer.parseInt(scanner.nextLine());
            }

            Matrix resultMatrix = null;

            switch (input) {
                case 1:
                    resultMatrix = firstMatrix.add(secondMatrix);
                    System.out.println("\n------------------------------");
                    System.out.println("Addition result:\n");
                    resultMatrix.print();
                    System.out.println("\n------------------------------");
                    break;

                case 2:
                    resultMatrix = firstMatrix.subtract(secondMatrix);
                    System.out.println("\n------------------------------");
                    System.out.println("Subtraction result:\n");
                    resultMatrix.print();
                    System.out.println("\n------------------------------");
                    break;

                case 3:
                    resultMatrix = firstMatrix.multiply(secondMatrix);
                    System.out.println("\n------------------------------");
                    System.out.println("Multiplication result:\n");
                    resultMatrix.print();
                    System.out.println("\n------------------------------");
                    break;

                case 4:
                    System.out.println("\n------------------------------");
                    System.out.print("Enter scalar value: ");
                    int scalar = Integer.parseInt(scanner.nextLine());
                    resultMatrix = firstMatrix.scalarMultiply(scalar);
                    System.out.println("\nFirst matrix scalar multiplication result:\n");
                    resultMatrix.print();

                    resultMatrix = secondMatrix.scalarMultiply(scalar);

                    System.out.println("\nSecond matrix scalar multiplication result:\n");
                    resultMatrix.print();
                    System.out.println("\n------------------------------");
                    break;

                case 5:
                    continueOperations = false;
                    System.out.println("\nExiting...");
                    break;

            }
        }

        System.out.println("\n-------------------Matrix Operations-------------------");

    }

    public void start() {
        System.out.println("\n===========================Matrix Calculator===========================\n");

        // Create the matrixes;
        Matrix firstMatrix = createMatrixInterface("first");
        System.out.println();
        Matrix secondMatrix = createMatrixInterface("second");

        // Print the matrixes;
        System.out.println();
        printMatrixes(firstMatrix, secondMatrix);

        // Perform operations
        System.out.println();
        performOperations(firstMatrix, secondMatrix);
        System.out.println();

        System.out.println("=======================================================================\n");
    }
}
