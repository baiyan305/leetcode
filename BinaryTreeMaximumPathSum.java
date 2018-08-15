// 124. Binary Tree Maximum Path Sum

public class BinaryTreeMaximumPathSum {

	public void run() {

    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    public int maxPathSum(TreeNode root, int[] max) {
        if(root == null) return 0;

        int leftMax = maxPathSum(root.left, max);
        int rightMax = maxPathSum(root.right, max);
        max[0] = Math.max(root.val + leftMax + rightMax, max[0]);

        return Math.max(root.val + Math.max(leftMax, rightMax), 0);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}