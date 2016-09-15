package com.goit.offline3.task1;

import java.util.concurrent.Semaphore;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Consumer extends Thread {

    private Semaphore semaphore;

    public Consumer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run(){
        int index = 0;
        while (true){
            try {
                System.out.println(++index+ " Consumer.acquire");
                semaphore.acquire();
                Thread.sleep(1000);
                System.out.println(++index+ " Consumer.release");
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
