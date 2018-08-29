package sword_offer.code16_合并两个排序的链表;

public class Solution {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = null;
        if (list1 != null && list2 == null) {
            head = list1;
            return head;
        } else if (list1 == null && list2 != null) {
            head = list2;
            return head;
        } else {
            if (list1.val >= list2.val) {
                head = list2;
                list2 = list2.next; // 一定要重新赋值下一个，否则会出现死循环，思考一下
                head.next = null;
            } else {
                head = list1;
                list1 = list1.next; // 一定要重新赋值下一个，否则会出现死循环，思考一下
                head.next = null;
            }
        }

        ListNode current = head;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        if (list1 != null)
            current.next = list1;
        if (list2 != null)
            current.next = list2;
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(9);
        list1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode list2 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(10);
        list2.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        PrintListNode.print(Merge(list1, list2));
//        PrintListNode.print(list2);
    }
}