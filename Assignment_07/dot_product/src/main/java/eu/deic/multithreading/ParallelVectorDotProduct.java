package eu.deic.multithreading;

class VectorDotProduct implements Runnable {
    private final double[] vector1;
    private final double[] vector2;
    private double result;
    private final int startIndex;
    private final int endIndex;

    public VectorDotProduct(double[] vector1, double[] vector2, int startIndex, int endIndex) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            result += vector1[i] * vector2[i];
        }
    }

    public double getResult() {
        return result;
    }
}

public class ParallelVectorDotProduct {
    private static final int VECTOR_SIZE = 20_000_000;
    private static final int NUM_THREADS = 8;

    private static double parallelDotProduct(double[] vector1, double[] vector2, int numThreads) {
        double dotProduct = 0.0;
        int chunkSize = vector1.length / numThreads;
        VectorDotProduct[] tasks = new VectorDotProduct[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? vector1.length : (i + 1) * chunkSize;
            tasks[i] = new VectorDotProduct(vector1, vector2, startIndex, endIndex);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        // Join all threads and sum up results
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                dotProduct += tasks[i].getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        // Generate random vectors
        double[] vector1 = new double[VECTOR_SIZE];
        double[] vector2 = new double[VECTOR_SIZE];

        for (int i = 0; i < VECTOR_SIZE; i++) {
            vector1[i] = Math.random();
            vector2[i] = Math.random();
        }

        System.out.println("\nBenchmark for dot product with vectors of size: " + VECTOR_SIZE + " and "
                + NUM_THREADS + " threads.\n");

        // Benchmarking
        for (int i = 1; i <= NUM_THREADS; i++) {
            long startTime = System.currentTimeMillis();
            double dotProduct = parallelDotProduct(vector1, vector2, i);
            long endTime = System.currentTimeMillis();
            System.out.println("\nDot product with " + i + " threads: " + dotProduct);
            System.out.println("Running time with " + i + " threads: " + (endTime - startTime) + " milliseconds");
        }
    }
}
