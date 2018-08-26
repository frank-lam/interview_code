package sword_offer.code6_从尾到头打印链表;

/**
 * @author Created By Frank
 * @date 2018-08-23 9:22
 * 从尾到头打印链表
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        stack.push(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().printListFromTailToHead(head));
    }
}