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
public class Exersice1Test {

    int[] arr;
    int variant;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 8, 5, 6};
        int[] arr3 = {4, 2, 3, 8, 5, 6};
        int[] arr4 = {1, 2, 3, 8, 5, 4};
        int[] arr5 = {4, 2, 3, 4, 4, 3};


        return Arrays.asList(new Object[][]{
                {arr1, 1},
                {arr2, 2},
                {arr3, 3},
                {arr4, 4},
                {arr5, 5}
        });
    }


    public Exersice1Test(int[] arr, int variant) {
        this.arr = arr;
        this.variant = variant;
    }

    @Test
    public void getArrAfterFor() throws Exception {

        switch (variant) {
            case 1:
                if (!Arrays.equals(Exersice1.getArrAfterFor(arr), new int[]{5, 6})) {
                    fail();
                }
                break;
            case 2:
                try {
                    Exersice1.getArrAfterFor(arr);
                    fail();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                if (!Arrays.equals(Exersice1.getArrAfterFor(arr), new int[]{2, 3, 8, 5, 6})) {
                    fail();
                }
                break;
            case 4:
                if (!(Exersice1.getArrAfterFor(arr).length == 0)) {
                    fail();
                }
                break;
            case 5:
                if (!Arrays.equals(Exersice1.getArrAfterFor(arr), new int[]{3})) {
                    fail();
                }
                break;

        }
    }

}