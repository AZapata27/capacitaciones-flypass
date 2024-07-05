package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.futuresCompletablesFutures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = () -> {
            Thread.sleep(2000);
            return "Task's execution";
        };

        Future<String> future = executor.submit(callableTask);

        try {
            if (!future.isDone()) {
                System.out.println("Task is still in progress...");
            }
            String result = future.get(); // Bloquea hasta que la tarea esté completa
            System.out.println("Task completed! Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
