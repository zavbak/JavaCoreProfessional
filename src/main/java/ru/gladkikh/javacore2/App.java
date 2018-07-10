package ru.gladkikh.javacore2;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        IntStream.range(5,20)
                .forEach(value -> System.out.println(value));
    }
}
