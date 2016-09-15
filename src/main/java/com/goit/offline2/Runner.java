package com.goit.offline2;

/**
 * Created by ANTON on 02.09.2016.
 */
public class Runner {

    public static Producer producer;
    public static Consumer consumer;

    public static void main(String[] args) {
         producer = new Producer();
         consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
