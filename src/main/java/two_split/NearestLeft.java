package two_split;

/**
 * 用二分法找出数组中大于等于num的最左边元素
 *
 */
public class NearestLeft {

    public static void main(String[] args) {

        int[] test = {1, 7, 5, 3, 7, 43, 67, 87};
        System.out.println(nearestLeft(test, 66));

    }


    /**
     * 大于等于num的最左元素
     *
     * @param arr
     * @param num
     * @return
     */
    public static int nearestLeft(int[] arr, int num) {

        int L = 0;
        int R = arr.length;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
