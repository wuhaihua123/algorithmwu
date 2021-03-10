package yihuo;

import sort.ArrayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 只有一种数出现了k次，其他数出现了m次，k<M.找出出现了k次的数
 */
public class KMTest {

    public static void main(String[] args) {
        int kinds = 5;
        int range = 200;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = kTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了");
            }
        }
        System.out.println("测试结束");

    }

    private static int test(int[] arr, int k, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entrySet) {
            if (integerIntegerEntry.getValue() == k) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;

    }

    private static int[] randomArray(int maxKinds, int range, int k, int m) {
        int kTimeNum = randNum(range);
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        int[] arr = new int[k + (numKinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = kTimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randNum(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        //arr已经搞定了，再打乱顺序
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            ArrayUtil.swap(arr, i, j);
        }
        return arr;
    }

    //[-range,range]
    private static int randNum(int range) {
        return (int) (Math.random() * range + 1) - (int) (Math.random() * range + 1);
    }


    public static int kTimes(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (help[i] % m == 0) {
                continue;
            }
            if (help[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }

        }
        if (ans == 0) {
            int count = 0;
            for (int i : arr) {
                if (i == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;

    }


}
