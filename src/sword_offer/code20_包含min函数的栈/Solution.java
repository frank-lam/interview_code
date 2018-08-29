package sword_offer.code20_包含min函数的栈;

import java.util.Stack;

public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();
    private int min;

    public void push(int node) {
        if(stack.isEmpty()){ // 如果栈为空的情况下
            stackMin.push(node);
        }
        else { // 不为空的情况下
            if(stackMin.peek() > node){
                stackMin.push(node);
            }
            else{
                stackMin.push(stackMin.peek());
            }
        }
        stack.push(node);

        min = stackMin.peek();
    }
    
    public void pop() {
        stack.pop();
        stackMin.pop();
        min = stackMin.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min;
    }

    public static void main(String[] args){

    }

}