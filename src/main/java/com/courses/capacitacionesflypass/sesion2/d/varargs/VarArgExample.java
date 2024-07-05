package com.courses.capacitacionesflypass.sesion2.d.varargs;

import java.util.List;

public class VarArgExample {

    // Método que suma una cantidad variable de números
    public static int sum(String nombre, int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Sum: " + sum("nombre", 2, 3)); // Output: Sum: 6
        System.out.println("Sum: " + sum("nombre", 5)); // Output: Sum: 9
        System.out.println("Sum: " + sum("nombre", 8, 9, 10,9,87,34)); // Output: Sum: 34
    }
}
