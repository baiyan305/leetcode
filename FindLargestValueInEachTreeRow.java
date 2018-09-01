// 515. Find Largest Value in Each Tree Row

import java.util.*;

public class FindLargestValueInEachTreeRow {
	
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

        System.out.println(largestValues(node5));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list, 0);
        return list;
    }

    private void recursion(TreeNode root, List<Integer> list, int depth) {
        if(root == null) return;

        if(depth >= list.size()) list.add(root.val);
        else list.set(depth, Math.max(root.val, list.get(depth)));

        recursion(root.left, list, depth+1);
        recursion(root.right, list, depth+1);
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}