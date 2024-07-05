package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.futuresCompletablesFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Task's execution";
        });

        future.thenAccept(result -> {
            System.out.println("Task completed! Result: " + result);
        });

        // Esperar a que todas las tareas completen (opcional)
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
