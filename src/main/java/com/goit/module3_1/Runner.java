package com.goit.module3_1;

import java.util.concurrent.ExecutionException;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Runner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final int arraySize = 999;
        final int numberOfThreads = 3;

        int[] values = new int [arraySize];
        for (int i = 0; i < arraySize; i++) {
            values[i] = i;
        }

        SquareSum squareSum = new SquareSumCalculator();

        long start = System.currentTimeMillis();
        System.out.println(squareSum.getSquareSum(values, numberOfThreads));
        long finish = System.currentTimeMillis();

        System.out.println(finish - start);

    }
}
