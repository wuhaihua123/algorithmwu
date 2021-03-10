package yihuo;

public class FindOddTimeNun {

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        findOddTimeNum(test);

        int[] test1 = {2001, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        findTwoOddTimeNum(test1);

    }

    /**
     * 在数组中，有一个数出现了奇数次，其他的数出现了偶数次
     *
     * @param arr
     * @return
     */
    public static void findOddTimeNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        System.out.println(eor);
    }

    /**
     * 在数组中，有两个数出现了奇数次，其他数字出现了偶数次
     *
     * @param arr
     */
    public static void findTwoOddTimeNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = extractRightestOne(eor);
        int eor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {
                eor1 ^= arr[i];
            }
        }
        System.out.println(eor1 + " " + (eor1 ^ eor));

    }

    /**
     * 提取二进制最右边的1
     *
     * @param a
     */
    public static int extractRightestOne(int a) {
        return a & (~a + 1);
        //等于a与上自己的相反数
//        return a&(-a);

    }
}
