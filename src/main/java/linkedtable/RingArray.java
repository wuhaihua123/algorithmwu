package linkedtable;


/**
 * 环形数组实现队列
 */
public class RingArray {

    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);

        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 环形数组取下标
         * @param i
         * @return
         */
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }


}
