package com.goit.module3;

/**
 * Created by ANTON on 02.09.2016.
 */
public class SemaphoreImpl implements Semaphore {

    private int permits;

    public SemaphoreImpl(int permits) {
        this.permits = permits;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        if(permits == 0){
            this.wait();
        }
        permits--;
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {

        for (int i = 0; i < permits; i++) {
            if(permits == 0){
                this.wait();
            }
            permits--;
        }
    }

    @Override
    public synchronized void release() {
        permits++;
        this.notify();

    }

    @Override
    public synchronized void release(int permits) {
        for (int i = 0; i < permits; i++) {
            this.permits++;
            this.notify();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
