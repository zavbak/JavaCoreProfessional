package ru.gladkikh.javacore2.homework1;
import java.util.ArrayList;
import java.util.Arrays;

public class  Exercise1 {

    /**
     *Change places cells of array
     *
     * @param arr
     * @param place1
     * @param place2
     * @param <T>
     */
    public static <T> void changePlases(T[] arr, int place1, int place2) {
        T value1 = arr[place1];
        T value2 = arr[place2];

        arr[place1] = value2;
        arr[place2] = value1;
    }

    public static <T> ArrayList<T> ArrayToList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        Arrays.stream(arr)
                .forEach(t -> {
                    arrayList.add(t);
                });
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println("Меняем месами элементы массива");
        Integer[] integers = {1,2,3,4};
        System.out.println(Arrays.toString(integers));

        Exercise1.changePlases(integers,2,3);
        System.out.println(Arrays.toString(integers));

        System.out.println("Массив в ArrayList");
        ArrayList<Integer> list = Exercise1.ArrayToList(integers);
        System.out.printf("Тип: %s Данные: %s",list.getClass().toString(),list.toString());
    }


}
