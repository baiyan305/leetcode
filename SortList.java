// 148. Sort List

public class SortList{

    public void run() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node3.next = node1;
        node1.next = node5;
        node5.next = node4;
        node4.next = node2;
        node2.next = node6;

        ListNode sorted = sortList(node3);
        System.out.println("123");
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = head, end = head.next;
        while(end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }
        ListNode rightStart = mid.next;
        mid.next = null;

        return merge(sortList(head), sortList(rightStart));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0), pointer = dummy;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }

        while(left != null) {
            pointer.next = left;
            left = left.next;
            pointer = pointer.next;
        }
        while(right != null) {
            pointer.next = right;
            right = right.next;
            pointer = pointer.next;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
