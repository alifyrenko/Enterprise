package com.goit.mosule2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ANTON on 25.08.2016.
 */
public class SerialExecutorTest {

    @Test(expected = IllegalStateException.class)
    public void addTask() throws Exception {

        Executor<Number> executor = new SerialExecutor();
        Task<Long> taskLong = new LongTask(10L,15L);
        Task<Integer> taskInt = new IntTask(-15,10);

        executor.addTask(taskInt);
        executor.addTask(taskLong);

        executor.execute();

        executor.addTask(taskInt);

    }

    @Test (expected = IllegalStateException.class)
    public void executeTest1() throws Exception {

        Executor<Number> executor = new SerialExecutor();
        executor.execute();

    }

    @Test
    public void executeTest2() throws Exception {


        Executor<Number> executor = new SerialExecutor();
        Task<Long> longTask = new LongTask(-10L,-15L);
        Task<Integer> intTask = new IntTask(-10,20);
        executor.addTask(intTask);
        executor.addTask(longTask);

        executor.execute();

        assertTrue(!executor.getInvalidResults().isEmpty());
        assertTrue(!executor.getValidResults().isEmpty());

    }

    @Test (expected = IllegalStateException.class)
    public void getValidResults() throws Exception {

        Executor<Number> executor = new SerialExecutor();
        executor.getValidResults();

    }

    @Test (expected = IllegalStateException.class)
    public void getInvalidResults() throws Exception {

        Executor<Number> executor = new SerialExecutor();
        executor.getInvalidResults();
    }

}