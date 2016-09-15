package com.goit.module3_1;

import java.util.concurrent.Callable;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Calculator implements Callable <Long> {

    private int valuesPerThread;
    private int [] values;
    private int counter;

    public Calculator(int valuesPerThread, int[] values, int counter) {
        this.valuesPerThread = valuesPerThread;
        this.values = values;
        this.counter = counter;
    }

    private long squaredValue;
    private long squaredSum;

    @Override
    public Long call() {
        for (int j = counter; j < valuesPerThread + counter; j++) {
            squaredValue = (long) Math.pow(values[j], 2);
            System.out.println(Thread.currentThread().getName() + ": " + squaredValue);
            squaredSum += squaredValue;
        }
        return squaredSum;
    }


}
