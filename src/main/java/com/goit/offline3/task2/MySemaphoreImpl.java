package com.goit.offline3.task2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ANTON on 09.09.2016.
 */
public class MySemaphoreImpl implements MySemaphore {

    private AtomicInteger permits;
    private AtomicInteger currentPoolSize;


    public MySemaphoreImpl(int permits) {
        this.permits = new AtomicInteger(permits);
        currentPoolSize = new AtomicInteger();
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        if (currentPoolSize.get()  == permits.get()){
                this.wait();
        }
            currentPoolSize.incrementAndGet();
    }

    @Override
    public void acquire(int permits) {

    }

    @Override
    public synchronized void release() {
        currentPoolSize.decrementAndGet();
        notify();
    }

    @Override
    public void release(int permist) {

    }
}
