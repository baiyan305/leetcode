// 24. Swap Nodes in Pairs

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode next = head.next, nextNext = head.next.next;
        head.next.next = head;
        head.next = swapPairs(nextNext);

        return next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
