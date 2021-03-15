package stack;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStackImplementQueue {

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }
        System.out.println(queue.poll());

    }

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPop = new Stack<>();
            this.stackPush = new Stack<>();
        }

        /**
         * 向队列中添加元素
         * @param value
         */
        public void offer(int value) {
            stackPush.push(value);
            pushToPop();
        }

        /**
         * push栈倒入pop栈
         */
        private void pushToPop() {
            //当pop栈不为空的时候，不能从push栈倒元素
            if (stackPop.isEmpty()) {
                //从push栈向pop栈倒入元素的时候，需要一次性倒干净
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }

        }

        /**
         * 从队列中弹出元素
         * @return
         */
        public int poll() {
            if (stackPush.empty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack has no data");
            }
            pushToPop();
            return stackPop.pop();
        }

        /**
         * 获取队列头部元素
         * @return
         */
        public int peek(){
            if (stackPush.empty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack has no data");
            }
            pushToPop();
            return stackPop.peek();
        }
    }
}
