package ru.gladkikh.javacore2.homework1.Exercise2.Entity;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> {
    List<E> list = new ArrayList<>();

    public void add(E e) {
        list.add(e);
    }

    public float getWeight() {
        return list.stream()
                .map(e -> {
                    return e.getWeight();
                }).reduce(0f, Float::sum);
    }


    public <T extends Fruit> boolean compare(Box<T> box) {
        return box.getWeight() == getWeight();
    }

    public void mix(Box<E> box) {
        box.getList().stream()
                .forEach(f ->{
                    list.add(f);
                } );
        box.list.clear();
    }

    public List<E> getList() {
        return list;
    }

    public int getSize(){
        return list.size();
    }

    @Override
    public String toString() {
        return "Box{" +
                " weight=" + getWeight() +
                " list=" + list +
                '}';
    }


}

