package sword_offer.code24_反转链表;

public class Solution {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode p = null;

        while (head != null) {
            p = head;
            head = head.next;
            p.next = pre;
            pre = p;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        PrintListNode.print(ReverseList(head));
    }
}