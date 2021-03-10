package sort;

import java.util.Arrays;

public class ArrayUtil {

    /**
     * 打印数组元素
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
