package com.goit.module3_1;

import java.util.concurrent.ExecutionException;

/**
 * Created by ANTON on 09.09.2016.
 */
public interface SquareSum {

    long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException;
}
