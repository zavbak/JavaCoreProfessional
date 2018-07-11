package ru.gladkikh.javacore2.homework3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exersice3 {

    private static String path = "d:" + File.separator + "test.txt";

    /**
     * Пишим большой фал
     */
    public static void writeFile() {
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {

            Random random = new Random();
            String str = "";

            for (int i = 0; i < 1024; i++) {
                str += random.nextInt();
            }


            long seek = 0;
            for (int i = 0; i < 1024; i++) {
                raf.write(str.getBytes());
                seek += str.length();
                raf.seek(seek);
            }

            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читаем постранично фал
     *
     * @param page     номер страницы
     * @param sizePage размер страницы
     */
    public static void read(int page, int sizePage) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            raf.seek(page * sizePage);

            byte[] arr = new byte[sizePage];
            raf.read(arr, 0, arr.length);
            System.out.println(new String(arr, StandardCharsets.UTF_8));

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполняем команду
     * @param s
     */
    private static void runCommand(String s){
         if (s.startsWith("exit")){
             Thread.currentThread().interrupt();
         }else{
             String[] strings = s.split(" ");
             if (strings.length != 2){
                 System.out.println("Не верные параметры!");
             }else{
                 try {
                     int page = Integer.parseInt(strings[0]);
                     int sizepage = Integer.parseInt(strings[1]);
                     read(page,sizepage);
                 } catch (NumberFormatException e) {
                     e.printStackTrace();
                     System.out.println("Не верные параметры!");
                 }
             }
         }
    }


    public static void main(String[] args) {
        writeFile();
        while (!Thread.interrupted()) {
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            runCommand(s);
        }
    }
}
