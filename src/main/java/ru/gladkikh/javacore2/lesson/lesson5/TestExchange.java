package ru.gladkikh.javacore2.lesson.lesson5;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.logging.Logger;

public class TestExchange {
    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        Logger log = Logger.getLogger(Exchanger.class.getName());

        log.info("khjkhjk");

        new Thread(() -> {
            Random random = new Random();
            try {
                System.out.println("Print 1 " + EXCHANGER.exchange("Thread 1: " + Integer.toString(random.nextInt())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            Random random = new Random();
            try {
                Thread.sleep(1000);
                System.out.println("Print 2 " + EXCHANGER.exchange("Thread 2: " + Integer.toString(random.nextInt())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
