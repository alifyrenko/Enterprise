package com.goit.module3_2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

/**
 * Created by ANTON on 05.09.2016.
 */
public class Synchronizers {

    public static void main(String[] args) throws InterruptedException {
        Synchronizers synchronizers = new Synchronizers();
        synchronizers.testExchanger();
    }


    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Barrier exceeded"));

        while (true) {
            new Thread(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " start waiting on barrier");
                    barrier.await();
                    System.out.println(threadName + " finish waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
    }


    public void testExchanger() {

        Exchanger<String> exchanger = new Exchanger<>();
        IntStream.range(0, 2).forEach((i) -> new Thread(() -> {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " ready to exchange");
                System.out.println(threadName + " < - > " + exchanger.exchange(threadName));
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start());
    }
}