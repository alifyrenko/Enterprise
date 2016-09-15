package com.goit.module1;

import java.util.Map;

/**
 * Created by ANTON on 23.08.2016.
 */
public class PrinterConsole {

    void printInConsole(Map<String , Double> map) {

        System.out.println("-------------------------------------");
        System.out.printf("%-25s%-11s\n", "Operation", "TimeSpent");
        System.out.println("-------------------------------------");

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            System.out.printf("%-25s%-11s\n", pair.getKey(), pair.getValue());
        }

    }
}
