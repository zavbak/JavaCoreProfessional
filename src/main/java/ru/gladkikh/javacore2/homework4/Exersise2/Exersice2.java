package ru.gladkikh.javacore2.homework4.Exersise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exersice2 {

    RandomAccessFile raf;


    public Exersice2() {

        String resultFilesPath = "d:" + File.separator + "result.txt";

        Path path = Paths.get(resultFilesPath);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            raf = new RandomAccessFile(path.toFile().getAbsolutePath(), "rw");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start(){
        MyThread myThread = new MyThread(this,"Поток 1");
        MyThread myThread1 = new MyThread(this,"Поток 2");
        MyThread myThread2 = new MyThread(this,"Поток 3");
        myThread.start();
        myThread1.start();
        myThread2.start();
        try {
            myThread.join();
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Exersice2 exersice2 = new Exersice2();
        exersice2.start();
    }

    synchronized void write(String str) {
        try {
            raf.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class MyThread extends Thread {

        Exersice2 exersice2;
        String name;

        public MyThread(Exersice2 exersice2,String name) {
            this.exersice2 = exersice2;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String str = "Строка " + i + " " + name + System.lineSeparator();
                exersice2.write(str);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finsh " + name);
        }
    }
}
