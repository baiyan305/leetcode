// 19. Remove Nth Node From End of List

public class RemoveNthNodeFromEndOfList {
	
	public void run() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = removeNthFromEnd(node1, 3);
        System.out.println("123");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0), prev = dummyHead, slow = head, fast = head;
        dummyHead.next = head;

        while(n-->0) fast = fast.next;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }

        prev.next = slow.next;
        slow.next = null;

        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
	
}