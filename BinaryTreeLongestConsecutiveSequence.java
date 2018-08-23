// 298. Binary Tree Longest Consecutive Sequence

public class BinaryTreeLongestConsecutiveSequence {
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node3;
        node3.left = node2;
        node3.right = node4;
        node4.right = node5;

        System.out.println(longestConsecutive(node1));
    }

    public int longestConsecutive(TreeNode root) {
        int[] longest = new int[1];
        recursion(root, longest);

        return longest[0];
    }

    private int recursion(TreeNode root, int[] longest) {
        if(root == null) return 0;

        int leftLen = recursion(root.left, longest), rightLen = recursion(root.right, longest);
        if(root.left == null || root.val != root.left.val - 1) leftLen = 0;
        if(root.right == null || root.val != root.right.val - 1) rightLen = 0;

        int res = 1 + Math.max(leftLen, rightLen);
        longest[0] = Math.max(longest[0], res);

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}