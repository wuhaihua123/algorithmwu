package sort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] test = {1, 5, 3, 4, 5, 6};
        bubbleSort(test);
        ArrayUtil.printArray(test);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
