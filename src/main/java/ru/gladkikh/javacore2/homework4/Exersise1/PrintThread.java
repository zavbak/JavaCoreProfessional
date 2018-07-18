package ru.gladkikh.javacore2.homework4.Exersise1;

public class PrintThread extends Thread {

    Object locker;
    private String str;

    public PrintThread(String str, Object locker) {
        this.str = str;
        this.locker = locker;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (locker) {
                try {
                    locker.wait();
                    System.out.println(str);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    break;
                }
            }

        }
    }


}
