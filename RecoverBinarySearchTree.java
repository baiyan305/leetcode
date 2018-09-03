// 99. Recover Binary Search Tree

import java.util.*;

public class RecoverBinarySearchTree {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;
        node4.left = node2;

        recoverTree(node3);

        System.out.println();
    }

	/* Morris Traversal
	public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;

        // Morris traversal
        while(root != null) {
            if(root.left != null) {
                TreeNode node = root.left;
                while(node.right != null && node.right != root) node = node.right;

                if(node.right != null) {
                    if(prev != null && prev.val >= root.val) {
                        if(first == null) first = prev;
                        second = root;
                    }
                    prev = root;

                    node.right = null;
                    root = root.right;
                } else {
                    node.right = root;
                    root = root.left;
                }

            } else {
                if(prev != null && prev.val >= root.val) {
                    if(first == null) first = prev;
                    second = root;
                }
                prev = root;

                root = root.right;
            }
        }

        if(first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
	*/
	
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
        inorder(root, nodes);

        if(nodes[1] != null && nodes[2] != null){
            int tmp = nodes[1].val;
            nodes[1].val = nodes[2].val;
            nodes[2].val = tmp;
        }
    }

    private void inorder(TreeNode root, TreeNode[] nodes) {
        if(root == null) return;

        inorder(root.left, nodes);
        if(nodes[0] != null && root.val <= nodes[0].val) {
            if(nodes[1] == null) nodes[1] = nodes[0];;
            nodes[2] = root;
        }
        nodes[0] = root;
        inorder(root.right, nodes);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}