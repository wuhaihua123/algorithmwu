package linkedtable;

import java.util.Stack;

/**
 * 栈实现队列
 * push栈和pop栈
 * 一次性从push栈倒入到pop栈
 * pop栈没有拿完，push栈不能倒入数据到pop栈
 */
public class QueueImplement {

    public static class TwoStackQueue {
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public TwoStackQueue() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        /**
         * 从push栈中倒入数据到pop栈
         */
        private void pushToPop() {
            if (popStack.empty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        /**
         * 添加元素
         *
         * @param value
         */
        private void add(int value) {
            pushStack.push(value);
            pushToPop();
        }

        /**
         * 取出元素
         *
         * @return
         */
        public int poll() {
            if (pushStack.empty() && popStack.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            pushToPop();
            return popStack.pop();
        }

        public int peek() {
            if (pushStack.empty() && popStack.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            pushToPop();
            return popStack.peek();

        }
    }
}
