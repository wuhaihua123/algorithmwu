package two_split;

public class PartialLeast {

    public static void main(String[] args) {

        int[] test = {1, 7, 5, 3, 6, 7, 4, 67, 7};
        System.out.println(findPartialLeast(test));

    }

    /**
     * 找到局部最小，0位置，如果比1位置小，那它就是局部最小
     * N位置，如果比N-1位置小，那它就是局部最小
     * 否则因为中间相邻位置不等，必然存在局部最小
     * 用二分法查找，如果mid位置数大于mid-1位置数小于mid+1位置数，返回mid
     * 如果mid>mid-1,则在左边二分
     * 如果mid+1>mid,则在右边二分
     *
     * @param arr
     * @return
     */
    public static int findPartialLeast(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        //满足0位置局部最小
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        //满足N位置局部最小
        if (arr.length - 1 < arr.length - 2) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;

    }
}
