// 98. Validate Binary Search Tree

public class ValidateBinarySearchTree {

    public void run() {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1 = new TreeNode(Integer.MIN_VALUE);
        root.left = node1;

        System.out.println(isValidBST(root));
    }

    // Inorder Traverse - recursion
    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        return inorder(root, prev);
    }

    public boolean inorder(TreeNode root, TreeNode[] prev) {
        if(root == null) return true;

        if(!inorder(root.left, prev)) return false;
        if(prev[0] != null && prev[0].val >= root.val) return false;
        prev[0] = root;
        return inorder(root.right, prev);
    }

    /* Inorder Traverse - Iterative with stack
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if(prev != null && node.val <= prev.val) return false;
            prev = node;
            root = node.right;
        }

        return true;
    }
    */

    /* Floor and ceiling
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursion(TreeNode root, long floor, long ceiling) {
        if(root == null) return true;

        long value = root.val;
        if(value < floor || value > ceiling) return false;

        return recursion(root.left, floor, value-1) && recursion(root.right, value+1, ceiling);
    }
    */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}