package ru.gladkikh.javacore2.homework3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exersec1 {
    private static String pathFile = "d:" + File.separator + "test.txt";

    public static void main(String[] args) {

        Path path = Paths.get(pathFile);
        try {
            byte[] arr = Files.readAllBytes(path);
            System.out.println(new String(arr, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
