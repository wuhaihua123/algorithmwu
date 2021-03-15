package daily;

import java.util.HashMap;
import java.util.Map;

public class FindShortestArray {

    public static void main(String[] args) {

        int[] test = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(test));
    }

    /**
     * 暴力方法，超出时间限制
     *
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        int ans = 1;
        int maxDegree = 1;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] array = map.get(nums[i]);
            if (array == null) {
                array = new int[]{1, i};
                map.put(nums[i], new int[]{1, i});
            } else {
                array[0]++;
            }
            if (array[0] > maxDegree) {
                maxDegree = array[0];
                ans = i - array[1] + 1;
            } else if (array[0] == maxDegree) {
                ans = Math.min(ans, i - array[1] + 1);
            }

        }
        return ans;

    }
}
