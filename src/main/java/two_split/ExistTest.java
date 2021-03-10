package two_split;

public class ExistTest {

    public static void main(String[] args) {
        int[] arr = {-1, 1, 2, 3, 4, 5, 65};
        System.out.println(exist(arr, -1));

    }

    /**
     * 用二分法判断有序数组中是否包含某个数字
     * 数组必须是有序数组
     * @param sortArr
     * @param num
     * @return
     */
    public static boolean exist(int[] sortArr, int num) {

        if (sortArr == null || sortArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortArr.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);//总是漏掉括号
            if (sortArr[mid] == num) {
                return true;
            } else if (sortArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortArr[L] == num;

    }
}
