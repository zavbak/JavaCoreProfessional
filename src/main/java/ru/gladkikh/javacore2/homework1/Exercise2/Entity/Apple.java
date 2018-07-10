package ru.gladkikh.javacore2.homework1.Exercise2.Entity;

public class Apple extends Fruit {
    public Apple(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "\nApple{" +
                "weight=" + getWeight() +
                '}';
    }
}
