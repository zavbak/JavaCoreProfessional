package ru.gladkikh.javacore2.homework6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@Slf4j
@RunWith(Parameterized.class)
public class Exersice2Test {

    int[] arr;
    int variant;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        int[] arr1 = {1, 4, 4, 4};
        int[] arr2 = {1, 2, 4, 4};
        int[] arr3 = {3, 2};
        int[] arr4 = {};


        return Arrays.asList(new Object[][]{
                {arr1, 1},
                {arr2, 2},
                {arr3, 3},
                {arr4, 4}
        });
    }

    public Exersice2Test(int[] arr, int variant) {
        this.arr = arr;
        this.variant = variant;
    }

    @Test
    public void getCheckForAndOne() throws Exception {
        switch (variant) {
            case 1:
                if (!Exersice2.getCheckForAndOne(arr)) {
                    fail();
                }
                break;
            case 2:
                if (Exersice2.getCheckForAndOne(arr)) {
                    fail();
                }
                break;
            case 3:
                if (Exersice2.getCheckForAndOne(arr)) {
                    fail();
                }
                break;
            case 4:
                if (Exersice2.getCheckForAndOne(arr)) {
                    fail();
                }
                break;

        }

    }

}