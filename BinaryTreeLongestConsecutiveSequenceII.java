// 549. Binary Tree Longest Consecutive Sequence II

import java.util.*;

public class BinaryTreeLongestConsecutiveSequenceII {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        System.out.println(longestConsecutive(node2));
    }

    // Leetcode discussion上面学的写法
    public int longestConsecutive(TreeNode root) {
        int[] longest = new int[1];
        recursion(root, longest);

        return longest[0];
    }

    // return longest consecutive path in increasing and decreasing
    // [0] increasing, [1] decreasing
    private int[] recursion(TreeNode root, int[] longest) {
        if(root == null) return new int[]{0,0};

        int[] leftRet = recursion(root.left, longest);
        int[] rightRet = recursion(root.right, longest);

        int increase = 1, decrease = 1;
        if(root.left != null){
            if(root.val+1 == root.left.val) increase += leftRet[0];
            else if(root.val-1 == root.left.val)decrease += leftRet[1];
        }
        if(root.right != null) {
            if(root.val+1 == root.right.val) increase = Math.max(increase, rightRet[0]+1);
            else if(root.val-1 == root.right.val) decrease = Math.max(decrease, rightRet[1]+1);
        }

        longest[0] = Math.max(longest[0], increase+decrease-1);

        return new int[]{increase, decrease};
    }

    /* 自己写的复杂解法，不够简练
    public int longestConsecutive(TreeNode root) {
        int[] longest = new int[1];
        recursion(root, longest);

        return longest[0];
    }

    private int[] recursion(TreeNode root, int[] longest) {
        if(root == null) return new int[]{0,0};

        int[] leftRet = recursion(root.left, longest);
        int[] rightRet = recursion(root.right, longest);

        int longestIncreasing = 1, longestDecreasing = 1;
        if(root.left != null) {
            if(root.val+1 == root.left.val)longestIncreasing += leftRet[0]; // increase
            if(root.val-1 == root.left.val)longestDecreasing += leftRet[1]; // decrease
        }
        if(root.right != null) {
            if(root.val+1 == root.right.val) longestIncreasing = Math.max(longestIncreasing, rightRet[0] + 1);
            if(root.val-1 == root.right.val) longestDecreasing = Math.max(longestDecreasing, rightRet[1] + 1);
        }
        longest[0] = Math.max(longest[0], Math.max(longestIncreasing, longestDecreasing));

        if(root.left != null && root.right != null) {
            if(root.left.val == root.val-1 && root.val+1 == root.right.val) longest[0] = Math.max(longest[0], 1+leftRet[1]+rightRet[0]);
            if(root.left.val == root.val+1 && root.val-1 == root.right.val) longest[0] = Math.max(longest[0], 1+leftRet[0]+rightRet[1]);
        }

        return new int[]{longestIncreasing, longestDecreasing};
    }
    */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}