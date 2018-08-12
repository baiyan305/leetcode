// 114. Flatten Binary Tree to Linked List

public class FlattenBinaryTreeToLinkedList {
	
	public void run() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        node5.left = node4;
        node5.right = node8;

        TreeNode node11 = new TreeNode(11);
        node4.left = node11;

        TreeNode node13 = new TreeNode(13);
        TreeNode node41 = new TreeNode(4);
        node8.left = node13;
        node8.right = node41;

        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node11.left = node7;
        node11.right = node2;

        TreeNode node51 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node41.left = node51;
        node41.right = node1;

        flatten(node5);
        System.out.println("123");
    }

    public void flatten(TreeNode root) {
        recursion(root);
    }

    // Return lastNode of flattened tree
    private TreeNode recursion(TreeNode root) {
        if(root == null) return null;

        TreeNode lastNodeOfLeftTree = recursion(root.left);
        TreeNode lastNodeOfRightTree = recursion(root.right);

        // flatten tree start from root
        if(root.left != null) {
            TreeNode firstNodeOfRightTree = root.right;
            root.right = root.left;
            lastNodeOfLeftTree.right = firstNodeOfRightTree;
            root.left = null;
        }

        // return last node of flattened tree
        if(lastNodeOfLeftTree == null && lastNodeOfRightTree == null) return root;
        return lastNodeOfRightTree == null ? lastNodeOfLeftTree : lastNodeOfRightTree;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}