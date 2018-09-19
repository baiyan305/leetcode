// 146. LRU Cache

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    public void run() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    // 使用LinkedList, 效率比较低
    class LRUCache {

        class Node{
            public int key, value;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        HashMap<Integer, Node> map;
        LinkedList<Node> list;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new LinkedList<>();
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;

            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node update = map.get(key);
                update.value = value;
                list.remove(update);
                list.addFirst(update);
                return;
            }

            if(map.size() == capacity) {
                map.remove(list.getLast().key);
                list.removeLast();
            }

            Node insert = new Node(key, value);
            list.addFirst(insert);
            map.put(key, insert);
        }

    }

    /* 自己实现双向链表
    class LRUCache {

        HashMap<Integer, Node> map = new HashMap<>();

        Node head, tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0,0,null,null);
            tail = new Node(0,0,null,null);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;

            Node node = map.get(key);
            removeNodeFromList(node);
            putNodeAtHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            // Key已经在LRUCache中。只更新Value，并将Node放到头部
            if(map.containsKey(key)) {
                Node update = map.get(key);
                update.value = value;
                removeNodeFromList(update);
                putNodeAtHead(update);

                return;
            }

            // 如果LRUCache已经满了，需要将尾部元素删除掉，从Map和Node List里面
            if(map.size() == capacity) {
                Node remove = tail.prev;
                removeNodeFromList(remove);
                map.remove(remove.key);
            }

            // 添加新的元素
            Node insert = new Node(key, value, null, null);
            putNodeAtHead(insert);
            map.put(key, insert);
        }

        private void putNodeAtHead(Node node) {
            Node first = head.next;
            head.next = node;
            node.prev = head;
            node.next = first;
            first.prev = node;
        }

        private void removeNodeFromList(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        class Node {
            public int key, value;
            public Node prev, next;
            Node(int key, int value, Node prev, Node next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
    }
    */
}
