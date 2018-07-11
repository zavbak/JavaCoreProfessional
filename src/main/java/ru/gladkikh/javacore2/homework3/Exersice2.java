package ru.gladkikh.javacore2.homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exersice2 {


    public static void main(String[] args) {


        String[] arrFilesPath = new String[5];
        arrFilesPath[0] = "d:" + File.separator + "test1.txt";
        arrFilesPath[1] = "d:" + File.separator + "test2.txt";
        arrFilesPath[2] = "d:" + File.separator + "test3.txt";
        arrFilesPath[3] = "d:" + File.separator + "test4.txt";
        arrFilesPath[4] = "d:" + File.separator + "test5.txt";

        String resultFilesPath = "d:" + File.separator + "result.txt";


        Path path = Paths.get(resultFilesPath);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (RandomAccessFile raf = new RandomAccessFile(path.toFile().getAbsolutePath(), "rw")) {

            for (int i = 0; i < arrFilesPath.length; i++) {
                try {
                    byte[] arr = Files.readAllBytes(Paths.get(arrFilesPath[i]));
                    raf.write(arr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
