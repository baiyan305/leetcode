// 117. Populating Next Right Pointers in Each Node II

public class PopulatingNextRightPointersInEachNodeII {
	public void run() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node7 = new TreeLinkNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        connect(node1);

        System.out.println("123");
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        while(start != null) {
            TreeLinkNode node = start, prev = null;
            start = null;
            while(node != null) {
                if(node.left != null) {
                    if(prev != null) prev.next = node.left;
                    prev = node.left;
                    if(start == null) start = node.left;
                }
                if(node.right != null) {
                    if(prev != null) prev.next = node.right;
                    prev = node.right;
                    if(start == null) start = node.right;
                }
                node = node.next;
            }
        }
    }
	
	public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}