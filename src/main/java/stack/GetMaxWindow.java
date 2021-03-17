package stack;

import java.util.Arrays;
import java.util.LinkedList;

public class GetMaxWindow {

    public static void main(String[] args) {

        int[] test = {1, 4, 45, 45, 51, 5, 1, 2};
        System.out.println(Arrays.toString(getMaxWindow(test, 3)));
    }


    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[i]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);
            /* 移除掉过期的值 */
            if (maxQueue.peekFirst() == i - w) {
                maxQueue.pollFirst();
            }
            //最大值获取
            if (i >= w - 1) {
                res[index++] = arr[maxQueue.peekFirst()];
            }

        }
        return res;

    }
}
