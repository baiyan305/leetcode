// 236. Lowest Common Ancestor of a Binary Tree

public class LowestCommonAncestorOfBinaryTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftRet = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRet = lowestCommonAncestor(root.right, p, q);

        if(leftRet == null && rightRet == null) return null;
        else if(leftRet != null) return leftRet;
        else if(rightRet != null) return rightRet;
        else return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
		
    }
}