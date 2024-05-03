package eu.deic.multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MatrixAdder implements Runnable {
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final double[][] result;
    private final int startRow;
    private final int endRow;

    public MatrixAdder(double[][] matrix1, double[][] matrix2, double[][] result, int startRow, int endRow) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        int cols = matrix1[0].length;
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
}

public class ParallelMatrixAddition {
    private static final int NUM_THREADS = 4;

    private static double[][] readMatrixFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            double[][] matrix = new double[rows][cols];
            int row = 0;
            while ((line = reader.readLine()) != null && row < rows) {
                String[] values = line.split("\\s+");
                for (int i = 0; i < values.length && i < cols; i++) {
                    matrix[row][i] = Double.parseDouble(values[i]);
                }
                row++;
            }
            return matrix;
        }
    }

    private static void writeMatrixToFile(String filename, double[][] matrix) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(matrix.length + "\n");
            writer.write(matrix[0].length + "\n");
            for (double[] row : matrix) {
                for (double value : row) {
                    writer.write(value + " ");
                }
                writer.write("\n");
            }
        }
    }

    private static void parallelMatrixAddition(double[][] matrix1, double[][] matrix2, double[][] result,
            int numThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int rowsPerThread = matrix1.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == numThreads - 1) ? matrix1.length : (i + 1) * rowsPerThread;
            executor.execute(new MatrixAdder(matrix1, matrix2, result, startRow, endRow));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFileName1 = "eu/deic/multithreading/matrix1.txt";
        String inputFileName2 = "eu/deic/multithreading/matrix2.txt";
        String outputFileName = "eu/deic/multithreading/result.txt";

        try {
            double[][] matrix1 = readMatrixFromFile(inputFileName1);
            double[][] matrix2 = readMatrixFromFile(inputFileName2);

            if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
                System.out.println("Matrices have different dimensions.");
                return;
            }

            double[][] result = new double[matrix1.length][matrix1[0].length];

            System.out.println("\nBenchmark for matrix addition with " + NUM_THREADS + " threads.");

            long startTime = System.currentTimeMillis();
            parallelMatrixAddition(matrix1, matrix2, result, NUM_THREADS);
            long endTime = System.currentTimeMillis();

            System.out.println("\nMatrix addition completed in " + (endTime - startTime) + " milliseconds.");

            writeMatrixToFile(outputFileName, result);
            System.out.println("\nResult written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
