package ru.gladkikh.javacore2.homework4;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();


        Thread threadA = new Thread(() -> {
           synchronized (lockA){
             while (true){
                 //try {
                     //lockA.wait();
                     System.out.println("A");
                 //} catch (InterruptedException e) {
                   //  e.printStackTrace();
                // }
             }
           }
        });

        threadA.start();

//        for (int i = 0; i < 5; i++) {
//            synchronized (lockA){
//                threadA.notify();
//            }
//        }

    }





}
