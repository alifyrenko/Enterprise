package com.goit.offline2;

import static com.goit.offline2.Runner.producer;

/**
 * Created by ANTON on 02.09.2016.
 */
public class Consumer implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                if(!producer.isProduced) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consumed: " + producer.number);
                producer.isProduced = false;

            }

            synchronized (producer){
                producer.notify();
            }
        }
    }
}
