package com.courses.capacitacionesflypass.sesion2.g.generic.boundedtype;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoundedTypeExampleMethods {



    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return Collections.max(list);
    }


    public <T>  T suma(List<T> numeros){


        return numeros.get(0);
    }


    public int nombre(String argumentos){
        return 1;
    }







    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Max in Integer List: " + findMax(intList));

        List<String> strList = Arrays.asList("apple", "banana", "cherry");
        System.out.println("Max in String List: " + findMax(strList));
    }
}
