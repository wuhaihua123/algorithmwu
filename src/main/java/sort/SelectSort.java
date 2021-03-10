package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] test = {1, 5, 3, 4, 5, 6};
        selectSort(test);
        printArray(test);

    }

    private static void printArray(int[] test) {
        System.out.println(Arrays.toString(test));
    }

    /**
     * 选择排序，N,N-1.。。。1的等差数列，复杂度O(N^2)
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
