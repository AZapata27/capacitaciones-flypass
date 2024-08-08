package com.courses.capacitacionesflypass.sesion3.e.debuggingprofiling.profiling;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {

    // Static list to simulate a memory leak
    private static List<Object> leakList = new ArrayList<>();

    // Method to add objects to the list
    public void addObjectToList(Object obj) {
        leakList.add(obj);
    }

    // Method to simulate some processing
    public void process() {
        for (int i = 0; i < 1000; i++) {
            addObjectToList(new byte[1024 * 1024]); // Add 1MB object to the list
        }
    }

    public static void main(String[] args) {
        MemoryLeakExample example = new MemoryLeakExample();

        // Run the process multiple times to simulate memory leak
        for (int i = 0; i < 100; i++) {
            example.process();
            System.out.println("Iteration " + i + " completed. Memory usage: " + 
                                (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " MB");
        }
    }
}
