package sort;

import static heap.HeapTest.heapInsert;
import static heap.HeapTest.heapify;
import static sort.ArrayUtil.swap;

/**
 * 数据量破倍，时间复杂度n*logN
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] test = {45, 435, 3, 6, 4367, 57, 4};
        heapSort(test);
        ArrayUtil.printArray(test);

    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //先构建大根堆
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for(int i = arr.length-1;i>=0;i--){
            //从下往上构建大根堆   时间复杂度O(n)   因为节点多的层数，查找次数少
            heapify(arr,i,arr.length);
        }
        int heapsize = arr.length;
        swap(arr, 0, --heapsize);
        while (heapsize > 0) {
            heapify(arr, 0, heapsize);
            swap(arr, 0, --heapsize);
        }
    }
}
