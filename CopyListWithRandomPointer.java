// 138. Copy List with Random Pointer

import java.util.*;

public class CopyListWithRandomPointer {
	public void run() {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node3.random = node1;

        node5.random = node3;

        RandomListNode copy = copyRandomList(node1);

        System.out.println("123");
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode copyHead = head, pre = null;
        while(head != null) {
            // creation of new node
            RandomListNode copy = map.containsKey(head) ? map.get(head) : new RandomListNode(head.label);
            map.put(head, copy);

            // handle next
            if(pre != null) pre.next = copy;
            pre = copy;

            // handle random
            if(head.random != null) {
                RandomListNode copyOfRandom = map.containsKey(head.random) ? map.get(head.random): new RandomListNode(head.random.label);
                map.put(head.random, copyOfRandom);
                copy.random = copyOfRandom;
            }

            head = head.next;
        }

        return map.get(copyHead);
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}