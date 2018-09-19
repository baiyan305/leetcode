// 141. Linked List Cycle

public class LinkedListCycle {

    public void run() {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null & fast.next != null) {
            fast = fast.next.next;
            slow = slow .next;
            if(fast == slow) return true;
        }

        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
