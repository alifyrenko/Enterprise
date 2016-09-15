package com.goit.offline.task1;

/**
 * Created by ANTON on 26.08.2016.
 */
public class MySampleThread implements Runnable{

    private String name;

    public MySampleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("\tMySympleThread.name = " + name + " started");
        for (int i = 0; i <10 ; i++) {
            System.out.println("\t\t " + name + "." + i);
        }
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\tMySympleThread.name = " + name + " COMPLETED");
    }
}
