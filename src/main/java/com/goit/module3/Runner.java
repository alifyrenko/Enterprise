package com.goit.module3;

import com.goit.offline.task1.MySampleThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ANTON on 02.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        SemaphoreImpl semaphore = new SemaphoreImpl(2);
        CommonSource commonSource = new CommonSource();

        for (int i = 0; i < 4; i++) {
            new Thread(new MyThread(semaphore, commonSource)).start();
        }
    }
}
