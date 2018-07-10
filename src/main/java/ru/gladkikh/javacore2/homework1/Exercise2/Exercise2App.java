package ru.gladkikh.javacore2.homework1.Exercise2;



import ru.gladkikh.javacore2.homework1.Exercise2.Entity.Apple;
import ru.gladkikh.javacore2.homework1.Exercise2.Entity.Box;
import ru.gladkikh.javacore2.homework1.Exercise2.Entity.Orange;

import java.util.stream.IntStream;

public class Exercise2App {

    public static float getWeight() {
        float leftLimit = 50f;
        float rightLimit = 200f;
        return leftLimit + (float) (Math.random() * (rightLimit - leftLimit));
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>(); //Box Apple
        IntStream.range(0, 5)
                .forEach(value -> {
                    appleBox.add(new Apple(getWeight()));
                    //appleBox.add(new Orange(getWeight())); //Error
                });

        Box<Orange> orangeBox = new Box<Orange>(); //Box Orange3
        IntStream.range(0, 5)
                .forEach(value -> {
                    orangeBox.add(new Orange(getWeight()));
                    //orangeBoxBox.add(new Apple(getWeight())); //Error
                });

        System.out.println(appleBox);
        System.out.println("\n");
        System.out.println(orangeBox);

        System.out.printf("\ncompare box: " + appleBox.compare(orangeBox));

        //appleBox.mix(orangeBox); //Erorr

        Box<Apple> appleBox2 = new Box<Apple>(); //Box Apple
        IntStream.range(0, 5)
                .forEach(value -> {
                    appleBox2.add(new Apple(getWeight()));
                    //appleBox.add(new Orange(getWeight())); //Error
                });

        System.out.println("\nПересыпаем...");
        System.out.println(appleBox);
        System.out.println(appleBox2);

        appleBox.mix(appleBox2);

        System.out.println("\n");
        System.out.println("Пересыпали");
        System.out.println(appleBox);
        System.out.println(appleBox2);


    }
}
