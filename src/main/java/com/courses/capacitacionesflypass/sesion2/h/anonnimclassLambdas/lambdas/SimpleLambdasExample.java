package com.courses.capacitacionesflypass.sesion2.h.anonnimclassLambdas.lambdas;

import java.util.Arrays;
import java.util.List;

public class SimpleLambdasExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        // Lambda para crear un Comparator
        names.sort((a, b) -> a.compareTo(b));

        System.out.println(names); // Output: [Alice, Bob, John]

        // Lambda para filtrar nombres que empiezan con "A"
        List<String> filteredNames = names
                .stream()
                .filter(name -> name.startsWith("A"))
                .distinct()
                .limit(2)
                .sorted()
                .filter(name -> name.length() < 5)
                .map(name -> name.toUpperCase())
                .toList();


        System.out.println(filteredNames); // Output: [JOHN, ALICE, BOB]
    }
}
