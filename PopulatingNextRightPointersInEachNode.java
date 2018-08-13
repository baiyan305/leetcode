// 116. Populating Next Right Pointers in Each Node

public class PopulatingNextRightPointersInEachNode {
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
        while(root != null) {
            TreeLinkNode node = root;
            while(node != null) {
                if(node.left != null) node.left.next = node.right;
                if(node.right != null && node.next != null) node.right.next = node.next.left;
                node = node.next;
            }
            root = root.left;
        }
    }
}