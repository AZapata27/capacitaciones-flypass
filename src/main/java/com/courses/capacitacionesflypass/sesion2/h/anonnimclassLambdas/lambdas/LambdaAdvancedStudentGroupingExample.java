package com.courses.capacitacionesflypass.sesion2.h.anonnimclassLambdas.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + '}';
    }
}

public class LambdaAdvancedStudentGroupingExample {

  
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Alice", 85.0),
                new Student("Bob", 65.0),
                new Student("Charlie", 95.0),
                new Student("David", 55.0),
                new Student("Eve", 75.0)
        );

        double passingGrade = 70.0;

        Predicate<Student> pasoLaMateria = student -> student.getGrade() > passingGrade;



        // Uso de funciones en el stream para agrupar estudiantes aprobados y reprobados
        Map<Boolean, List<Student>> groupedByPassFail =
                students.stream()
                .collect(Collectors.partitioningBy(pasoLaMateria));


        System.out.println("Estudiantes Aprobados: " + groupedByPassFail.get(true));

        System.out.println("Estudiantes Reprobados: " + groupedByPassFail.get(false));



         }
}
