package ru.gladkikh.javacore2.homework1.Exercise2.Entity;

public class Orange extends Fruit {
    public Orange(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "\nOrange{" +
                "weight=" + getWeight() +
                '}';
    }
}
