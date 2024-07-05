package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.futuresCompletablesFutures;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AsyncExample example = new AsyncExample();

        CompletableFuture<String> future = example.performAsyncTask();

        CompletableFuture<String> future2 = example.performAsyncTask();


        for (int i = 0; i < 1000; i++) {
            procesoNormal(i);
        }


        String result = future.get();
        System.out.println(result);
    }

    private static void procesoNormal(int i) {
        System.out.println("Procesando normal: " + i);
    }

    @Async
    public CompletableFuture<String> performAsyncTask() {

        return CompletableFuture.supplyAsync(() -> {

            simularEsperaDilay();
            System.out.println("ESTE MENSAJE ES DESPUES DE LA ESPERA DE ALGO BLOQUEANTE EN EL PROCESO ASINCORNO");

            return "Resultado de la operación asincrona";

        }).exceptionally(ex -> {

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
