package linkedtable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 自己是先一个栈，有push，pop和获取最小值的功能，时间复杂度为O(1)
 * 队列实现栈
 */
public class StackImplement {

    public static class TwoQueueStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        private void add(T value) {
            queue.offer(value);
        }

        /**
         * 弹出元素
         * @return
         */
        private T poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            //queue和help的引用互换
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        private T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            //queue和help的引用互换
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
    }

}
