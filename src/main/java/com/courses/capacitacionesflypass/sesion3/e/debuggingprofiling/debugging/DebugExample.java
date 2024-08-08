package com.courses.capacitacionesflypass.sesion3.e.debuggingprofiling.debugging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DebugExample {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        DebugExample example = new DebugExample();

        // Start the complex processing
        List<Integer> numbers = example.generateNumbers();
        System.out.println("Generated Numbers: " + numbers);

        // Process the numbers using streams
        List<Integer> processedNumbers = example.processNumbers(numbers);
        System.out.println("Processed Numbers: " + processedNumbers);

        // Perform asynchronous computation
        try {
            List<Integer> asyncResults = example.performAsyncComputations(processedNumbers);
            System.out.println("Asynchronous Computation Results: " + asyncResults);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // Handle exceptions in streams
        try {
            example.processNumbersWithExceptions(processedNumbers);
        } catch (Exception e) {
            System.out.println("Exception caught during stream processing: " + e.getMessage());
        }

        // Simulate a deadlock
        example.simulateDeadlock();
    }

    public List<Integer> generateNumbers() {
        return IntStream.range(0, 10)
                .map(i -> RANDOM.nextInt(100))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .filter(n -> n > 50)
                .collect(Collectors.toList());
    }

    public List<Integer> performAsyncComputations(List<Integer> numbers) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for (Integer number : numbers) {
            futures.add(CompletableFuture.supplyAsync(() -> complexComputation(number), executorService));
        }

        List<Integer> results = new ArrayList<>();
        for (CompletableFuture<Integer> future : futures) {
            results.add(future.get());
        }

        executorService.shutdown();
        return results;
    }

    public void processNumbersWithExceptions(List<Integer> numbers) {
        numbers.stream()
                .map(n -> {
                    if (n % 4 == 0) {
                        throw new RuntimeException("Number is divisible by 4");
                    }
                    return n * 2;
                })
                .forEach(System.out::println);
    }

    public void simulateDeadlock() {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private Integer complexComputation(Integer number) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }
}
