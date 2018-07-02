package leetcode.code203_remove_linked_list_elements;

/**
 * @author Created By Frank
 * @date 2018-06-26 18:26
 */

/**
 * 删除链表中的节点 - LeetCode (中国)
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 */


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}