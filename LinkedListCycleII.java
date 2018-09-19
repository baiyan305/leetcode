// 142. Linked List Cycle II
public class LinkedListCycleII {

    public void run() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        ListNode cycle = detectCycle(node1);
        System.out.println("123");
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        // 前面的while循环有两个终止条件。
        // 如果是因为 fast == slow 终止的，证明有环。那么fast和fast.next都不会为null。
        // 如果是因为 fast == null 或者 fast.next == null终止的，那么证明没有环。
        if(fast==null || fast.next == null) return null;

        ListNode node = head;
        while(node != slow) {
            node = node.next;
            slow = slow.next;
        }

        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
