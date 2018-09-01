// 513. Find Bottom Left Tree Value

public class FindBottomLeftTreeValue {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        System.out.println(findBottomLeftValue(node1));
    }

    // DFS
    public int findBottomLeftValue(TreeNode root) {
        return recursion(root)[1];
    }

    // [0] - depth, [1] - value
    private int[] recursion(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        if(root.left == null && root.right == null) return new int[]{1, root.val};

        int[] left = recursion(root.left), right = recursion(root.right);
        return new int[]{Math.max(left[0], right[0]) + 1, left[0] >= right[0] ? left[1] : right[1]};
    }

    /* BFS - Level order traverse
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }

        return root.val;
    }
    */
	
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
