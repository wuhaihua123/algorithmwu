package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找数组中出现两次的数
 */
public class FindNumOccurTwoTimes {

    public static void main(String[] args) {
        int[] test = {3, 415, 4, 51, 5, 15, 1, 51, 4, 5, 5, 4, 45, 12, 1, 12, 4};
        findNumOccurTwoTimes(test);

    }

    /**
     * 时间复杂度O(n),额外空间复杂度O(1)
     *
     * @param arr
     */
    public static List findNumOccurTwoTimes(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return list;
        }
        Arrays.sort(arr);
        int last = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == last) {
                count++;
            } else {
                if (count == 2) {
                    list.add(last);
                }
                count = 1;
                last = arr[i];
            }
        }
        return list;

    }
}
