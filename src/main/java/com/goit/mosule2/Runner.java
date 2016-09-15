package com.goit.mosule2;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 23.08.2016.
 */
public class Runner {

    public static void main(String[] args) {

        Executor<Number> executor = new SerialExecutor();

        executor.addTask(new LongTask(10L,15L));
        executor.addTask(new IntTask(10,30));
        executor.addTask(new LongTask(10L,-5L));

        executor.addTask(new LongTask(10L, 15L), result -> result.longValue() > 0);
        executor.addTask(new IntTask(-5,-15), result -> result.intValue() > 0);
        executor.addTask(new LongTask(5L,-5L), result -> result.longValue() > 0);

        executor.execute();

        executor.getValidResults();
        executor.getInvalidResults();
    }
}
