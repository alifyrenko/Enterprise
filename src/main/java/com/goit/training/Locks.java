package com.goit.training;

import java.util.concurrent.*;

/**
 * Created by ANTON on 05.09.2016.
 */
public class Locks {

    public static void main(String[] args) {
        Locks locks = new Locks();
        locks.test();
    }

	 public void test() {
            		ExecutorService executorService = Executors.newSingleThreadExecutor();
                   Future<String> f = executorService.submit((Callable<String>) () -> {
                            throw new RuntimeException("Exception happened");
                        });
                    try {
                           System.out.println("result: " + f.get());
                       } catch (Exception e) { }
            	executorService.shutdown();
            	 }
 }


