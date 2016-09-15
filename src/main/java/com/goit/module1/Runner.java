package com.goit.module1;

import java.io.IOException;
import java.util.*;

import static com.goit.module1.Constants.INIT_CAPACITY;

/**
 * Created by ANTON on 08.08.2016.
 */
public class Runner {


    public static void main(String[] args) throws IOException {

        int capacity = INIT_CAPACITY;
        CollectionsTimeMeasurer collectionsTimeMeasurer = new CollectionsTimeMeasurer();
        ExcelWriter excelWriter = new ExcelWriter();
        PrinterConsole printerConsole = new PrinterConsole();

        List<Collection<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<Integer>());
        list.add(new LinkedList<Integer>());
        list.add(new HashSet<Integer>());
        list.add(new TreeSet<Integer>());

        for (int i = 0; i < list.size(); i++) {
            collectionsTimeMeasurer.measureTimeOfPopulate(capacity, list.get(i));
            collectionsTimeMeasurer.measureTimeOfRemove(capacity, list.get(i));
            collectionsTimeMeasurer.measureTimeOfContains(capacity, list.get(i));
            collectionsTimeMeasurer.measureTimeOfAddition(capacity, list.get(i));
        }

        List<List<Integer>> listLists = new ArrayList<>();

        listLists.add(new ArrayList<Integer>());
        listLists.add(new LinkedList<Integer>());

        for (int i = 0; i < listLists.size(); i++) {
            collectionsTimeMeasurer.measureTimeOfIteratorAdd(capacity, listLists.get(i));
            collectionsTimeMeasurer.measureTimeOfIteratorRemove(capacity, listLists.get(i));
            collectionsTimeMeasurer.measureTimeOfGet(capacity, listLists.get(i));
        }

        printerConsole.printInConsole(CollectionsTimeMeasurer.getMap());

        excelWriter.prepareTable();
        excelWriter.fillExcelTable(CollectionsTimeMeasurer.getMap());

    }
}
