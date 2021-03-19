package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GetNearLess {

    public static void main(String[] args) {

        int[] test = new int[]{3, 4, 1, 5, 6, 2, 7};
        int[][] s = getNearLessNoRepeat(test);
        for (int i = 0; i < s.length; i++) {
            System.out.println(Arrays.toString(s[i]));
        }
        
    }

    /**
     * 无重复数组求每个元素的最近最小元素位置信息
     * 用单调栈实现
     *
     * @param nums
     * @return
     */
    public static int[][] getNearLessNoRepeat(int[] nums) {
        int[][] res = new int[nums.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;

    }


    /**
     * 有重复数组求每个元素的最近最小元素位置信息
     * 用单调栈实现
     *
     * @param nums
     * @return
     */
    public static int[][] getNearLessRepeat(int[] nums) {
        int[][] res = new int[nums.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek().get(0)] > nums[i]) {
//                int popIndex = stack.pop();
                List<Integer> popIndexs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popIndex : popIndexs) {
                    res[popIndex][0] = leftLessIndex;
                    res[popIndex][1] = i;
                }
            }
            if (!stack.isEmpty() && nums[stack.peek().get(0)] == nums[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIndexs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popIndex : popIndexs) {
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = -1;
            }

        }
        return res;


    }
}
