package stack;

import java.util.Stack;

public class ReverseStackWithRecursive {
    /**
     * 用递归的方法逆序栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int bottomNum = getAndRemoveLastElement(stack);
        //找到下一个栈底元素
        reverse(stack);
        //将弹出的栈底元素压入栈
        stack.push(bottomNum);

    }

    /**
     * 后去并移除栈底元素
     *
     * @param stack
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(num);
            return last;
        }
    }
}
