package sort;

import java.util.Arrays;

/**
 * 归并排序  时间复杂度O(N*logN)
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 6, 4, 7, 7};
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
        int[] copy = copyArray(arr);
        mergeSort2(copy);
        System.out.println(Arrays.toString(copy));

    }

    private static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);//这种写法不会溢出
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //同时只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    /**
     * 利用归并排序求小和
     *
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process1(arr, 0, arr.length - 1);
    }

    private static int process1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);//这种写法不会溢出
        return process1(arr, L, mid) + process1(arr, mid + 1, R) + merge1(arr, L, mid, R);
    }

    private static int merge1(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        int ans = 0;
        while (p1 <= mid && p2 <= R) {
            ans += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //同时只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;


    }

    //求小和

    //非递归版本
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {

            int L = 0;
            while (L < N) {
                int M = 0;
                if (N - L >= step) {
                    M = L + step - 1;//防止L+step-1越界
                } else {
                    M = N - 1;
                }
                if (M == N - 1) {
                    break;
                }
                int R = 0;
                if (N - 1 - M >= step) {
                    R = M + step;//防止M+step越界
                } else {
                    R = N - 1;
                }
                merge(arr, L, M, R);
                if (R == N - 1) {
                    break;
                } else {
                    L = R + 1;
                }
            }


            //防止步长溢出
            if (step > N / 2) {
                break;
            } else {
                step *= 2;
            }

        }
    }

    /**
     * 查找逆序对
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return processx(nums, 0, nums.length - 1);
    }

    private static int processx(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        return processx(arr, L, mid) + processx(arr, mid + 1, R) + mergex(arr, L, mid, R);
    }

    private static int mergex(int[] arr, int L, int mid, int R) {
        int N = R - L + 1;
        int[] help = new int[N];
        int p1 = mid;
        int p2 = R;
        int i = N - 1;
        int ans = 0;
        while (p1 >= L && p2 > mid) {
            if (arr[p1] > arr[p2]) {
                ans += p2 - mid;
            }
            // ans += arr[p1] > arr[p2] ? p2-mid : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        //同时只有一个越界
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 >= mid + 1) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;


    }


    //找到右边乘2比左边小的数
    public int moreThan2TimesNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return processy(nums, 0, nums.length - 1);
    }

    private int processy(int[] nums, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        return processy(nums, L, mid) + processy(nums, mid + 1, R) + mergey(nums, L, mid, R);
    }

    private int mergey(int[] arr, int L, int mid, int R) {
        int ans = 0;
        int windowR = mid + 1;
        for (int i = L; i < mid; i++) {
            //如果左边的数大于右边的数，右边的下标右滑，直到滑不动
            while (windowR < R && arr[i] > arr[windowR] * 2) {
                windowR++;
            }
            ans += windowR;
        }


        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //同时只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;

    }

    //求数组中的子数组和在某个范围之内

    public static int countRangeSum(int[] arr, int lower, int upper) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //前缀和数组
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return count(sum, 0, sum.length - 1, lower, upper);

    }

    public static int count(int[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            if (sum[L] >= lower && sum[L] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }

        //L不等于R
        int mid = L + ((R - L) >> 1);
        int left = count(sum, L, mid, lower, upper);
        int right = count(sum, mid + 1, R, lower, upper);
        int merge = merge11(sum, L, mid, R, lower, upper);
        return left + right + merge;

    }

    private static int merge11(int[] sum, int L, int mid, int R, int lower, int upper) {
        //不merge，但是对于右边中的每个数，求左组中有多少个数在范围中x-upper，x-lower

        int ans = 0;
        int windowL = L;
        int windwoR = R;
        //对于右组的每个数，找出左组中x-upper，x-lower范围上的数
        for (int i = mid + 1; i < R; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (windwoR <= mid && sum[windwoR] <= max) {
                windwoR++;
            }

            while (windowL <= mid && sum[windowL] < min) {
                windowL++;
            }
            ans += windwoR - windowL;

        }
        //正常merge
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        //同时只有一个越界
        while (p1 <= mid) {
            help[i++] = sum[p1++];
        }
        while (p2 <= R) {
            help[i++] = sum[p2++];
        }
        for (i = 0; i < help.length; i++) {
            sum[L + i] = help[i];
        }

        return ans;

    }
}
