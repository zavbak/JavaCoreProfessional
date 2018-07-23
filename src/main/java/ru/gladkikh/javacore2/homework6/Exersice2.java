package ru.gladkikh.javacore2.homework6;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;


@Slf4j
public class Exersice2 {

    /**
     * Проверим что массив состоит только из 4 и 1
     *
     * @param arr
     * @return
     */
    public static boolean getCheckForAndOne(int[] arr) {

        if (arr.length == 0) {
            return false;
        }

        return Arrays.stream(arr)
                .filter(value -> {
                    return !(value == 4 || value == 1);
                }).count() == 0;

    }

}
