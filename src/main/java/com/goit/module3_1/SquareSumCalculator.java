package com.goit.module3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * Created by ANTON on 08.09.2016.
 */
public class SquareSumCalculator implements SquareSum {

    //private final Phaser phaser = new Phaser();
    long result = 0;

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {


        int valuesPerThread = values.length / numberOfThreads;
        int counter = 0;

        List<Callable<Long>> callables = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);


        for (int i = 0; i < numberOfThreads; i++) {
            callables.add(new Calculator(valuesPerThread, values, counter * valuesPerThread));
            counter++;
        }

        List<Future<Long>> futures = service.invokeAll(callables);

        for (Future<Long> future : futures) {
            result += future.get();
        }

        service.shutdown();
        return result;
    }
}
