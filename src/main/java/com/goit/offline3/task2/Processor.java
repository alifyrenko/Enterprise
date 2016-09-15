package com.goit.offline3.task2;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Processor extends Thread {

    private MySemaphore mySemaphore;

    public Processor(MySemaphore mySemaphore) {
        this.mySemaphore = mySemaphore;
    }

    public void run() {

        try {
            mySemaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " release");
        mySemaphore.release();
    }
}
