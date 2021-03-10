package heap;

import static sort.ArrayUtil.swap;

public class HeapTest {

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(-1 / 2);
        //默认PriorityQueue小根堆
    }

    /**
     * 从上往下沉  二叉树堆高logN，调整级别的时间复杂度为logN
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            //右节点存在并且右节点大于左节点，返回右节点
            int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }
}
