// 337. House Robber III

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = recursion(root);
        return Math.max(res[0], res[1]);
    }

    // 对于每个节点，返回两个值.
    // 第一个值，是包含这个节点的最大值.
    // 第二个值，是不包含这个节点的最大值.
    private int[] recursion(TreeNode root) {
        if(root == null) return new int[2];

        int[] left = recursion(root.left);
        int[] right = recursion(root.right);
        int[] res = new int[2];

        res[0] = root.val + left[1] + right[1]; // 包含当前节点, left[1]是左子树不包含左节点的最大值, right[1]是右子树不包含右节点的最大值
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不包含当前节点

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
