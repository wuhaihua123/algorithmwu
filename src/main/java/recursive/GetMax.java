package recursive;

public class GetMax {

    public static void main(String[] args) {
        int[] test = {1, 34, 643, 46, 436, 7, 57};
        System.out.println(getMax(test));
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 递归获取数组中的最大值
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
