// 206. Reverse Linked List

public class ReverseLinkedList {

    // 递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;

        return newHead;
    }

    /* 非递归
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
    */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
