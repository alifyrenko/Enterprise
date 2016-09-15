package com.goit.module1;

import java.io.IOException;
import java.util.*;

import static com.goit.module1.Constants.*;

/**
 * Created by ANTON on 08.08.2016.
 */
public class CollectionsTimeMeasurer {

    private double start;
    private double finish;
    private double result;
    private int changesQuantity = CHANGES_QUANTITY;

    private String collectionName;

    public static Map<String, Double> getMap() {
        return map;
    }

    private static Map<String, Double> map = new HashMap<>();

    void measureTimeOfPopulate(int capacity, Collection<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        start = System.nanoTime()/1000;
        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "Populate", result);
        collection.clear();
    }

    void measureTimeOfAddition(int capacity, Collection<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }

        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            collection.add(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "Add", result);
        collection.clear();

    }

    void measureTimeOfRemove(int capacity, Collection<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }

        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            collection.remove(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "Remove", result);
        collection.clear();
    }

    void measureTimeOfContains(int capacity, Collection<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }

        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            collection.contains(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "Contains", result);
        collection.clear();
    }

    void measureTimeOfGet(int capacity, List<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }

        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            collection.get(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "Get", result);
        collection.clear();
    }

    void measureTimeOfIteratorAdd(int capacity, List<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }

        ListIterator<Integer> iterator = collection.listIterator();
        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            iterator.add(i);
        }
        finish = System.nanoTime()/1000;
        result = finish - start;
        map.put(collectionName + "IteratorAdd", result);
        collection.clear();
    }

    void measureTimeOfIteratorRemove(int capacity, List<Integer> collection) throws IOException {

        collectionName = collection.getClass().toString().substring(16);

        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }
        ListIterator<Integer> iterator = collection.listIterator();

        start = System.nanoTime()/1000;
        for (int i = 0; i < changesQuantity; i++) {
            iterator.next();
            iterator.remove();
        }
        finish = System.nanoTime()/1000;
        result = finish - start;

        map.put(collectionName + "IteratorRemove", result);
        collection.clear();
    }
    
}
