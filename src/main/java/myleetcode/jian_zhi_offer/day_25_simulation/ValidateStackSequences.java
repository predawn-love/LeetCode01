package myleetcode.jian_zhi_offer.day_25_simulation;

import java.util.Stack;

public class ValidateStackSequences {
    /**
     * 自己写的
     */
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if (pushed.length == 0) {
//            if (popped.length == 0) {
//                return true;
//            }
//            return false;
//        }
//        Stack<Integer> stack = new Stack<>();
//        int curIndexPushed = 0;
//        int curIndexPopped = 0;
//        stack.push(pushed[curIndexPushed++]);
//        while (true) {
//            if (stack.isEmpty() || stack.peek().intValue() != popped[curIndexPopped]) {
//                if (curIndexPushed == pushed.length) {
//                    return false;
//                }
//                stack.push(pushed[curIndexPushed++]);
//            } else {
//                stack.pop();
//                curIndexPopped++;
//                if (curIndexPopped == popped.length) {
//                    return true;
//                }
//            }
//        }
//    }

    /**
     * 题解上的模拟栈
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int curPopIndex = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek().intValue() == popped[curPopIndex]) {
                stack.pop();
                curPopIndex++;
            }
        }
        return stack.isEmpty();
    }
}
