package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Adding elements
        concurrentMap.put("key1", 1);
        concurrentMap.put("key2", 2);

        // Reading elements
        int value = concurrentMap.get("key1");
        System.out.println("Value for key1: " + value);

        // Modifying elements concurrently
        concurrentMap.compute("key2", (key, val) -> val + 1);
        System.out.println("Value for key2: " + concurrentMap.get("key2"));
    }
}
