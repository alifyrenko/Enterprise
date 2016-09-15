package com.goit.offline3.task1;

import java.util.concurrent.Semaphore;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Producer extends Thread {

    private Semaphore semaphore;
    private String name;


    public Producer(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void run(){

        while (true) {
            try {
                semaphore.acquire();
                System.out.println(name + " Producer.acquire");
                Thread.sleep(3000);
                semaphore.release();
                System.out.println(name + " Producer.release");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

