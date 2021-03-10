package sort;


/**
 * 插入排序，假设前面的n-1个数已经排好序
 *
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] test = {1, 5, 3, 4, 5, 6};
        insertSort(test);
        ArrayUtil.printArray(test);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                ArrayUtil.swap(arr, j, j - 1);
//            }
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtil.swap(arr, j, j + 1);
            }
        }
    }
}
