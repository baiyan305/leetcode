// 141. Linked List Cycle

import yan.bai.Instance;

public class LinkedListCycle {

    public void run() {

    }

    public boolean hasCycle(Instance.ListNode head) {
        Instance.ListNode slow = head, fast = head;

        while(fast != null & fast.next != null) {
            fast = fast.next.next;
            slow = slow .next;
            if(fast == slow) return true;
        }

        return false;
    }

    public class ListNode {
        int val;
        Instance.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
