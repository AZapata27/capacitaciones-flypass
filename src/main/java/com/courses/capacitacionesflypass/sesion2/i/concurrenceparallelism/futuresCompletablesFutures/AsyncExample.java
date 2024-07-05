package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.futuresCompletablesFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {

    public static void main(String[] args) {

        AsyncExample example = new AsyncExample();
        CompletableFuture<String> future = example.performAsyncTask();


        for (int i = 0; i < 1000; i++) {
            procesoNormal(i);
        }


        try {

            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void procesoNormal(int i) {
        System.out.println("Procesando normal: " + i);
    }

    public CompletableFuture<String> performAsyncTask() {
        return CompletableFuture.supplyAsync(() -> {

            simularEsperaDilay();
            System.out.println("ESTE MENSAJE ES DESPUES DE LA ESPERA DE ALGO BLOQUEANTE EN EL PROCESO ASINCORNO");
            // Simula una operación asincrónica
            return "Resultado de la operación asincrona";
        }).thenApply(result -> {
            // Procesa el resultado
            return result.toUpperCase();
        }).exceptionally(ex -> {
            // Maneja excepciones
            System.err.println("Ocurrió un error: " + ex.getMessage());
            return "Valor por defecto";
        });
    }

    private void simularEsperaDilay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
