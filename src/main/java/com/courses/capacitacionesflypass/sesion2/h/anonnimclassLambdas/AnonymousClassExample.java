package com.courses.capacitacionesflypass.sesion2.h.anonnimclassLambdas;

public class AnonymousClassExample {
    public static void main(String[] args) {


        // Creación de una clase anónima que implementa la interfaz Runnable
        Runnable runnable = () -> System.out.println("Hello from a!");

        // Ejecutar la clase anónima
        new Thread(runnable).start();
    }
}
