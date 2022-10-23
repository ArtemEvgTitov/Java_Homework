package Seminar_2;

import java.util.Arrays;

// Реализовать алгоритм сортировки вставками

public class task_2 {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] myArray = { 1, 5, 2, 9, 43, 5, 7, 1 };
        myArray = insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

}
