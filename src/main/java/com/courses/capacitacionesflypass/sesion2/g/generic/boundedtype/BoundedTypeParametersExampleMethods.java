package com.courses.capacitacionesflypass.sesion2.g.generic.boundedtype;

public class BoundedTypeParametersExampleMethods {


    public static <T extends Number> double sum(T num1, T num2) {

        return num1.doubleValue() + num2.doubleValue();

    }




    public static void main(String[] args) {

        System.out.println("Sum: " + sum(10L, 20));

        System.out.println("Sum: " + sum(15F, 10.3));
    }
}
