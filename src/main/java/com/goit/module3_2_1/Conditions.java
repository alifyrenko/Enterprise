package com.goit.module3_2_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ANTON on 05.09.2016.
 */
public class Conditions {


    public static void main(String[] args) {

    }

    public static class TransferQueue<T> {

        private final Lock lock = new ReentrantLock();
        private final Condition full = lock.newCondition();
        private final Condition empty = lock.newCondition();

        Object[] items;
        int putIndex = 0;
        int takeIndex = 0;
        int size = 0;

        public TransferQueue(int capacity) {
            items = new Object[capacity];
        }

        public void put(T value) throws InterruptedException {
            lock.lock();
            try {
                while (size == items.length) {
                    System.out.println("Queue is full. " + Thread.currentThread().getName() + " start waiting");
                    full.await();
                }
                items[putIndex] = value;
                if (++putIndex == items.length){
                    putIndex =0;
                }
                size++;
                empty.signal();

            } finally {
                lock.unlock();
            }
        }

        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (size == 0){
                    empty.await();
                }

                T result = (T) items[takeIndex];

                if(++takeIndex == items.length){
                    takeIndex =0;
                }
                size--;
                full.signal();
                return result;
            } finally {
                lock.unlock();
            }
        }
    }
}
