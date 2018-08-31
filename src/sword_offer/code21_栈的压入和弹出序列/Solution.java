package sword_offer.code21_栈的压入和弹出序列;


import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1
 * 是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：
 * 这两个序列的长度是相等的）
 * <p>
 * 思路：借助一个辅助栈，将入栈序列依次入栈，栈顶元素与所给出的出栈队列相比，如果相同则出栈，
 * 如果不同，则继续入栈，直到原入栈序列全部入栈为止；检测辅助栈是否为空，若空，说明出栈
 * 队列正确，否则不正确。
 */

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA1 = {4, 5, 3, 2, 1}; //  true
        int[] popA2 = {4, 3, 5, 1, 2}; // false
        System.out.println(new Solution().IsPopOrder(pushA, popA1));
        System.out.println(new Solution().IsPopOrder(pushA, popA2));
    }
}