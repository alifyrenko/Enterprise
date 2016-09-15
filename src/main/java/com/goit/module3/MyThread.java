package com.goit.module3;

/**
 * Created by ANTON on 02.09.2016.
 */
public class MyThread implements Runnable {

    private SemaphoreImpl semaphore;
    private CommonSource commonSource;

    public MyThread(SemaphoreImpl semaphore, CommonSource commonSource) {
        this.semaphore = semaphore;
        this.commonSource = commonSource;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " ожидает разрешения");
            semaphore.acquire(5);
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + commonSource.x);
                commonSource.x++;
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " освобождается");
            semaphore.release(3);
        }
    }
}
