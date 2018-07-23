package ru.gladkikh.javacore2.homework6;


import lombok.extern.slf4j.Slf4j;



@Slf4j
public class Exersice1 {

    /**
     * Вернем массив после последней четверки
     * @param arr
     * @return
     */
    public static int[] getArrAfterFor(int[] arr){

        for (int i = arr.length -1; i>=0 ; i--) {
            if (arr[i] == 4){
                int[] newArr = new int[arr.length - i -1];
                System.arraycopy(arr, i+1, newArr,0,newArr.length);
                return  newArr;
            }
        }

        throw new RuntimeException();
    }

}
