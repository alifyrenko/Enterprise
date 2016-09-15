package com.goit.offline3.task2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ANTON on 09.09.2016.
 */
public class MySemaphoreLockImpl implements MySemaphore{

    private AtomicInteger permits;
    private Lock lock;
    private Condition condition;

    public MySemaphoreLockImpl(int permits) {
        this.permits = new AtomicInteger(permits);
        this.lock = new ReentrantLock(true);
        condition = lock.newCondition();
    }

    @Override
    public void acquire() throws InterruptedException {
        try {
            lock.lock();
            if (permits.get() == 0) {
                condition.await();
            }
            permits.decrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void acquire(int permits) {

    }

    @Override
    public void release() {
        try {
            lock.lock();
            condition.signalAll();
            permits.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void release(int permist) {

    }
}
