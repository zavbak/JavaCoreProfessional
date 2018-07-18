package ru.gladkikh.javacore2.homework4.Exersise1;

public class Exersice1 {

    static final Object lockA = new Object();
    static final Object lockB = new Object();
    static final Object lockC = new Object();

    public static void main(String[] args) throws InterruptedException {

        PrintThread printThreadA = new PrintThread("А", lockA);
        PrintThread printThreadB = new PrintThread("B", lockB);
        PrintThread printThreadC = new PrintThread("C", lockC);
        printThreadA.start();
        printThreadB.start();
        printThreadC.start();


        //System.out.println("");
        for (int i = 0; i < 5; i++) {

            while (printThreadA.getState() != Thread.State.WAITING) {

            }

            synchronized (lockA) {
                lockA.notify();
            }


            while (printThreadB.getState() != Thread.State.WAITING) {

            }

            synchronized (lockB) {
                lockB.notify();
            }

            while (printThreadC.getState() != Thread.State.WAITING) {

            }

            synchronized (lockC) {
                lockC.notify();
            }

        }

        while (printThreadA.getState() != Thread.State.WAITING) {

        }
        printThreadA.interrupt();

        while (printThreadB.getState() != Thread.State.WAITING) {

        }
        printThreadB.interrupt();

        while (printThreadC.getState() != Thread.State.WAITING) {

        }
        printThreadC.interrupt();


    }
}
