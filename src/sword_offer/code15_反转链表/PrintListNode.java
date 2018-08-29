package sword_offer.code15_反转链表;

/**
 * @author Created By Frank
 * @date 2018-08-26 21:43
 */
public class PrintListNode {
    public static void print(ListNode head){
        if(head==null){
            System.out.println("ListNode is empty!!!");
        }
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}