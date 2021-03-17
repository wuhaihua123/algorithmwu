package sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] testArray = {9, 5, 6, 7, 8, 4, 5};
//        quickSortWithoutRecursion(testArray);
        quickSort(testArray);
        System.out.println(Arrays.toString(testArray));


    }


    /**
     * 以最后一个数区分，小于区和大于区
     *
     * @param arr
     */
    public static void splitNum(int[] arr) {
        //小于等于区的最右边
        int lessThanR = -1;
        //当前位置
        int currentPos = 0;
        //最右边的下标
        int N = arr.length;
        while (currentPos < N) {
            //如果当前位置数小余等于最右边的数,等于是把自己插入到小于等于区的下一个数
            if (arr[currentPos] <= arr[N - 1]) {
                swap(arr, ++lessThanR, currentPos++);
            } else {
                currentPos++;
            }
        }
    }

    /**
     * 小于区  等于区   大于区
     *
     * @param arr
     */
    public static void splitNum2(int[] arr) {
        int N = arr.length;
        int lessR = -1;
        int moreL = N - 1;
        int index = 0;
        while (index < moreL) {
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[N - 1]) {
                swap(arr, --moreL, index);

            } else {
                index++;
            }
        }
        swap(arr, moreL, N - 1);
    }

    private static void swap(int[] arr, int i, int currentPos) {
        int temp = arr[i];
        arr[i] = arr[currentPos];
        arr[currentPos] = temp;
    }

    /**
     * 返回等于区域
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] partition(int[] arr, int L, int R) {
        //小于区
        int lessR = L - 1;
        //大于等于区
        int moreL = R;
        int index = L;
        while (index < moreL) {
            //以最右边的数作为比较值
            if (arr[index] < arr[R]) {
                //如果小于，交换小于区右边的数和当前的数位置
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                //如果大于，交换大于区的最左边和当前数位置
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR + 1, moreL};
    }

    /**
     * 快排
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalP = partition(arr, L, R);
        process(arr, L, equalP[0] - 1);
        process(arr, equalP[1] + 1, R);

    }

    //非递归版本
    public static class Job {
        public int L;
        public int R;

        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }

    //没有递归的快排
    public static void quickSortWithoutRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job curr = stack.pop();
            int[] equalP = partition(arr, curr.L, curr.R);
            if (equalP[0] > curr.L) {
                stack.push(new Job(curr.L, equalP[0] - 1));
            }
            if (equalP[1] < curr.R) {
                stack.push(new Job(equalP[1] + 1, curr.R));
            }

        }

    }
}
