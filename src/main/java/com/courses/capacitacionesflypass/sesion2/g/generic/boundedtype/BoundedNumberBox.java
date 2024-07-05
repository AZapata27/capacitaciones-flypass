package com.courses.capacitacionesflypass.sesion2.g.generic.boundedtype;

public class BoundedNumberBox<T extends Number> {

    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public double doubleValue() {
        return content.doubleValue();
    }

    public static void main(String[] args) {

        BoundedNumberBox<Integer> intBox = new BoundedNumberBox<>();
        intBox.setContent(10);

        BoundedNumberBox<Long> longBox = new BoundedNumberBox<>();
        longBox.setContent(10L);


        BoundedNumberBox<Double> doubleBox = new BoundedNumberBox<>();
        doubleBox.setContent(10.0);


        System.out.println("Double Value: " + intBox.doubleValue());
    }
}
