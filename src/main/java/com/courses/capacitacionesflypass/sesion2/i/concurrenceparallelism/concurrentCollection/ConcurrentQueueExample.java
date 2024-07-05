package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // Adding elements
        queue.offer("Element1");
        queue.offer("Element2");

        // Polling elements
        String element = queue.poll();
        System.out.println("Polled element: " + element);

        // Peeking elements
        String peekedElement = queue.peek();
        System.out.println("Peeked element: " + peekedElement);
    }
}
