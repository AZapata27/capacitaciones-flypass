package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.futuresCompletablesFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AdvancedCompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            return "Result of Future 2";
        });

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + " and " + result2;
        });


        // Manejo de excepciones
        combinedFuture.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null;
        });

        String resutlCombinado = combinedFuture.get();

        System.out.println(resutlCombinado);

    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
