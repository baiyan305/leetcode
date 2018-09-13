// 23. Merge k Sorted Lists

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public void run() {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node41 = new ListNode(4);
        ListNode node42 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node11.next = node41;
        node41.next = node5;

        node12.next = node3;
        node3.next = node42;

        node2.next = node6;

        //ListNode[] lists = {node11, node12, node2};
        ListNode[] lists = {};
        ListNode merged = mergeKLists(lists);


        System.out.println("123");
    }

    // 将ListNode的开头放到PriorityQueue中
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode head : lists) {
            if(head != null) queue.add(head);
        }

        ListNode dummyHead = new ListNode(0), pointer = dummyHead;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            pointer = node;
            if(node.next != null) queue.add(node.next);
        }

        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}