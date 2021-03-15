package stack;

import java.util.Stack;

/**
 * 实现一个可获取最小值的栈
 */
public class GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    /**
     * 压入元素
     *
     * @param newNum
     */
    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getMin()) {
            stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    /**
     * 弹出元素
     *
     * @return
     */
    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack has no data");
        }
        this.stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stack has no data");
        }
        return stackMin.peek();
    }
}
