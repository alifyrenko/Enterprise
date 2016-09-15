package com.goit.offline2;


import static com.goit.offline2.Runner.*;

/**
 * Created by ANTON on 02.09.2016.
 */
public class Producer implements Runnable {

    int number;
    boolean isProduced;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (isProduced) {

                    try {
                        Thread.sleep(1000);
                        this.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Produced: " + (++number));
                isProduced = true;
            }

            synchronized (consumer){
                consumer.notify();
            }
        }

    }
}