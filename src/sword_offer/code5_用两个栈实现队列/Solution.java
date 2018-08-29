package sword_offer.code5_用两个栈实现队列;

import java.util.Stack;

public class Solution {
    public static Stack<Integer> stack1 = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();

    // 入队
    public void push(int node) {
        stack1.push(node);
    }

    // 出队列
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int tempNode = stack1.pop();
                stack2.push(tempNode);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        new Solution().push(1);
        new Solution().push(2);
        new Solution().push(3);
        new Solution().push(4);



        System.out.println(new Solution().pop());
        System.out.println(new Solution().pop());

    }
}