package eu.deic.multithreading;

import java.util.Random;

class Vector implements Runnable {
    private final int[] vector1;
    private final int[] vector2;
    private final int[] resultVector;
    private final int startIndex;
    private final int endIndex;

    public Vector(int[] vector1, int[] vector2, int[] resultVector, int startIndex, int endIndex) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.resultVector = resultVector;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            resultVector[i] = vector1[i] + vector2[i];
        }
    }

}

public class ParallelVectorAddition {

    private static final int VECTOR_SIZE = 40_000_000;
    private static final int NUM_THREADS = 8;

    private static void parallelAddition(int[] vector1, int[] vector2, int[] resultVector, int noOfThreads) {
        int chunkSize = vector1.length / vector2.length;
        Thread[] threads = new Thread[noOfThreads];

        for (int i = 0; i < noOfThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == noOfThreads - 1) ? vector1.length : (i + 1) * chunkSize;
            threads[i] = new Thread(new Vector(vector1, vector2, resultVector, startIndex, endIndex));
            threads[i].start();
        }

        // ! Join the threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] vector1 = new int[VECTOR_SIZE];
        int[] vector2 = new int[VECTOR_SIZE];
        int[] resultVector = new int[VECTOR_SIZE];

        Random random = new Random();
        for (int i = 0; i < VECTOR_SIZE; i++) {
            vector1[i] = random.nextInt(100);
            vector2[i] = random.nextInt(100);
        }

        System.out.println("\nBenchmark for vector addition with vectors of size: " + VECTOR_SIZE + " and "
                + NUM_THREADS + " threads.\n");

        // ! Benchmarking
        for (int i = 1; i <= NUM_THREADS; i++) {
            long startTime = System.currentTimeMillis();
            parallelAddition(vector1, vector2, resultVector, i);
            long endTime = System.currentTimeMillis();
            System.out.println("Running time with " + i + " threads: " + (endTime - startTime) + " milliseconds.");
        }
    }
}
