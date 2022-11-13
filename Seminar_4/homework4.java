package Seminar_4;

import java.util.Arrays;

public class homework4 {

    public static void quickSort(int[] array, int low, int high) {

        if (array.length == 0) 
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int supportElement = array[middle];
        int i = low, j = high;

        while (i <= j) {
            while (array[i] < supportElement) {
                i++;
            }

            while (array[j] > supportElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        int[] firstArray = { 6, 0, 4, -4, 2, 7, 34, 2, -3 };
        int low = 0;
        int high = firstArray.length - 1;
        quickSort(firstArray, low, high);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = {};
        high = secondArray.length - 1;
        quickSort(secondArray, low, high);
        System.out.println(Arrays.toString(secondArray));

    }
}
