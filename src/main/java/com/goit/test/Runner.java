package com.goit.test;

/**
 * Created by ANTON on 09.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        final int arraySize = 333_333;


        int[] value = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            value[i] = i;
        }

        long result = 0;


        long start = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {
            result += (long) Math.pow(value[i],2);
        }

        long finish = System.currentTimeMillis();

        System.out.println(result);
        System.out.println(finish - start);

    }

}
