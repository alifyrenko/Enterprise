package com.goit.module3_2_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by ANTON on 05.09.2016.
 */
public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ExecutorsExample().testScheduledAtFixedRate();
    }

    public  void testExecute(){
        Executor executor = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " submit task");
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " Asynch task started"));
    }


    public void testSubmit() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Task executed";
            }
        });

        System.out.println("Waiting for result");
        System.out.println("result " + f.get());

        executorService.shutdown();
    }


    public void testException() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("Exception happened");
            }
        });

        System.out.println("Waiting for result");
        Thread.sleep(1000);
        try {
            System.out.println("result " + f.get());
        } catch (Exception e){
            System.out.println("Caught exception");
        }

        executorService.shutdown();
    }


    public void testInvokeAny() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0,3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newCachedThreadPool();
        String result = executorService .invokeAny(callables);

        System.out.println(result);

        executorService.shutdown();
    }


    public void testInvokeAll() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0,3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = executorService .invokeAll(callables);

        for (Future<String> stringFuture : result) {
            System.out.println(stringFuture.get());
        }


        executorService.shutdown();
    }


    public void testScheduled(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.schedule(() -> System.out.println("Task executed " + new Date()), 1, TimeUnit.SECONDS);

        executorService.shutdown();
    }


    public void testScheduledAtFixedRate() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.scheduleAtFixedRate(() -> System.out.println("Task executed " + new Date()),1, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);
        executorService.shutdown();
    }



}
