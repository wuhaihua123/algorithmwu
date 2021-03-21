package stack;

import java.util.LinkedList;

/**
 * 从数组中找出最大值和最小值的差小于给定值Num的字数组的个数
 */
public class GetNumsForSubArEqualsGivenNum {
    public static void main(String[] args) {

        int[] test = {5,4,3,6,3,2};

        System.out.println(getNum(test, 2));

    }


    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        int res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                //minQueue中last存放的是进入队列中最新的下标
                //当最大数和最小数的差大于num时，跳出循环，此时i++
                //当j没有向右边推时，只需要判断一下释放掉的队列头部元素是不是之前的i
                //如果因此改变了最大数和最小数的差，使得小于等于num
                //那j再向右边推
                //主要保证没有下标进出maxQueue和minQueue队列一次
                if (minQueue.isEmpty() || minQueue.peekLast() != j) {
                    while (!minQueue.isEmpty() && arr[maxQueue.peekLast()] >= arr[j]) {
                        minQueue.pollLast();
                    }
                    minQueue.addLast(j);
                    while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[j]) {
                        maxQueue.pollLast();
                    }
                    maxQueue.addLast(j);
                }
                if (arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            if (minQueue.peekFirst() == i) {
                minQueue.pollFirst();
            }
            if (maxQueue.peekFirst() == i) {
                maxQueue.pollFirst();
            }
            i++;

        }
        return res;

    }
}
