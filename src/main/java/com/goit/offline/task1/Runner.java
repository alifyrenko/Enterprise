package com.goit.offline.task1;

/**
 * Created by ANTON on 26.08.2016.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started");

        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(new MySampleThread("Name" + i + " " + Thread.currentThread().getName()));
            thread.start();
            thread.join();
        }

        System.out.println("Application finished");

    }
}
