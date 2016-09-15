package com.goit.offline;

/**
 * Created by ANTON on 26.08.2016.
 */
public class Runner {
    public static void main(String[] args) {

        Processor processorA = new Processor("A");
        Processor processorB = new Processor("B");
        //processorA.process();
        //processorB.process();

        processorA.start();
        processorB.start();


    }
}
