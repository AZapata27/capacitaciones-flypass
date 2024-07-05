package com.courses.capacitacionesflypass.sesion2.j.designpattern.creacionales;

interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}


abstract class AnimalFactory {

    abstract Animal createAnimal();

    void doSomething() {
        Animal animal = createAnimal();
        animal.speak();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Cat();
    }
}

// Cliente
public class FactoryMethodExample {

    public static void main(String[] args) {

        AnimalFactory dogFactory = new DogFactory();
        dogFactory.doSomething();

        AnimalFactory catFactory = new CatFactory();
        catFactory.doSomething();
    }
}
