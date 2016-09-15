package com.goit.offline3.task2;

/**
 * Created by ANTON on 09.09.2016.
 */
public interface MySemaphore {

    void acquire() throws InterruptedException;
    void acquire(int permits);
    void release();
    void release(int permist);

}
