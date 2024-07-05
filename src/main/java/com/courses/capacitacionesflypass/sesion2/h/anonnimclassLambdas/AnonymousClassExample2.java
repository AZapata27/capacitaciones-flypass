package com.courses.capacitacionesflypass.sesion2.h.anonnimclassLambdas;

public class AnonymousClassExample2 {

    @FunctionalInterface
    interface Person {

        void displayInfo();
    }

    public static void main(String[] args) {

        // Creación de una clase anónima que extiende la clase Person
        Person personEstrategy1 = ()-> System.out.println("Strategia 1.");

        Person personEstrategy2 = ()-> System.out.println("Strategia 2.");

        Person personEstrategy3 = ()-> System.out.println("Strategia 2.");



        if(algunacondicion()){
            // Llamada al método de la clase anónima
            personEstrategy1.displayInfo();
        }

    }

    private static boolean algunacondicion() {
        return true;
    }
}
