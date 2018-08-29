package sword_offer.code14_链表中倒数第k个结点;

import java.util.Stack;

public class Solution {
    public static ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<>();

        while(head!=null){
            stack.push(head);
            head = head.next;
        }

        int count = 0;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            count++;
            if(count == k){
                return node;
            }
        }
        return null;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(FindKthToTail(head, 2).val);
    }
}