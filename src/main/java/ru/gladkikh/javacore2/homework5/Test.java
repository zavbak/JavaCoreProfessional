package ru.gladkikh.javacore2.homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);

        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            new Thread(() -> {

                try {
                    barrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

//            new Thread(() -> {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Start");
//                try {
//                    barrier.await();
//                    System.out.println(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//
//            }).start();
        }
        
    }

}
