package com.goit.offline3.task1;


import java.util.concurrent.Semaphore;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 30; i++) {
            new Producer(semaphore, "Item #" + i).start();
        }

    }

}
