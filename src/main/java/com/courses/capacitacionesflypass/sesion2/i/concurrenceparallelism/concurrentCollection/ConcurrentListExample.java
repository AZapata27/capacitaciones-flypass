package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.ConcurrentModificationException;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


        // Adding elements
        list.add("Element1");
        list.add("Element2");

        // Reading elements
        for (String element : list) {
            System.out.println("Element: " + element);
        }
    }
}
