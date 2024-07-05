package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSetExample {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();

        // Adding elements
        set.add("Element1");
        set.add("Element2");

        // Iterating elements
        for (String element : set) {
            System.out.println("Element: " + element);
        }
    }
}
