package com.goit.offline3.task2;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Runner {

    public static void main(String[] args) throws InterruptedException {

        MySemaphore mySemaphore = new MySemaphoreLockImpl(2);

        for (int i = 0; i < 30; i++) {
            new Processor(mySemaphore).start();
        }

    }
}
