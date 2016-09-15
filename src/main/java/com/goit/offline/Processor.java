package com.goit.offline;

/**
 * Created by ANTON on 26.08.2016.
 */
public class Processor extends Thread{

    private String name;

    public Processor(String name) {
        this.name = name;
        //setDaemon(true);

    }

    public void process (){
        for (int i = 0; i <100 ; i++) {
            System.out.println(String.format("%s.%s", i,name));
        }
    }

    @Override
    public void run() {
        process();
    }
}
