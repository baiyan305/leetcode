// 86. Partition List

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), large = new ListNode(0);
        ListNode smallBak = small, largeBak = large;

        while(head != null) {
            if(head.val < x) small = small.next= head;
            else large = large.next = head;

            head = head.next;
        }

        large.next = null;
        small.next = largeBak.next;

        return smallBak.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
