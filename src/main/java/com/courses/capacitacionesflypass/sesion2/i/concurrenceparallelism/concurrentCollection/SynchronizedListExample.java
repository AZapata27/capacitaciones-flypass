package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SynchronizedListExample {
    private final List<String> list = Collections.synchronizedList(new ArrayList<>());

    public void addElement(String element) {
        synchronized (list) {
            list.add(element);
        }
    }

    public void iterateElements() {
        synchronized (list) {
            for (String element : list) {
                System.out.println("Element: " + element);
            }
        }
    }
}
