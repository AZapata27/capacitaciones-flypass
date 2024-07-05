package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewConcurrencyExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.printf("Running in %s thread: %s %n", i,  Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simular trabajo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        executor.submit(task);
        executor.submit(task);


        System.out.println("Main thread start .");
        executor.shutdown();


        System.out.println("Main thread finished.");
    }

    @Async
    public void calcularcualquiercosa(){

    }
}
