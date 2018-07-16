package ru.gladkikh.javacore2.homework4.Exersice3;

public class Exersice3 {
    public static void main(String[] args) throws InterruptedException {
        MFU mfu = new MFU();
        mfu.start();

        Thread.sleep(1000);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5 ; i++) {
                mfu.print();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5 ; i++) {
                mfu.scan();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread.join();
        thread1.join();
        mfu.stop();
    }



}
