package ru.gladkikh.javacore2.homework4;

import java.util.stream.IntStream;

public class Test {


    public static void main(String[] args) {

        MyThread thredPrintC = new MyThread(null, "C");
        MyThread thredPrintB = new MyThread(thredPrintC, "B");
        MyThread thredPrintA = new MyThread(thredPrintB, "A");


        thredPrintA.start();
        thredPrintB.start();
        thredPrintC.start();


        IntStream.range(1, 5)
                .forEach(value -> {
                    synchronized (thredPrintA) {
                        thredPrintA.notify();
                    }

                });

        thredPrintA.interrupt();
        thredPrintB.interrupt();
        thredPrintC.interrupt();

    }


    static class MyThread extends Thread {

        String str;
        Object notifyObj;

        public MyThread(Object notifyObj, String str) {
            this.str = str;
            this.notifyObj = notifyObj;
        }

        @Override
        public void run() {
            synchronized (this) {

                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        this.wait();
                        System.out.print(str);

                        if (notifyObj != null) {
                            synchronized (notifyObj) {
                                notifyObj.notify();
                            }
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }

        }
    }


}
