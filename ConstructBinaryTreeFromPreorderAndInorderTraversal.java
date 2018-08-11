// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public void run() {
        int[] preorder = {1,2,4,8,9,5,10,3,6,11,12,7,13}, inorder = {8,4,9,2,5,10,1,11,6,12,3,13,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("123");
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder, 0, preorder.length-1, 0);
    }

    private TreeNode recursion(int[] preorder, int[] inorder, int left, int right, int idx) {
        if(left > right) return null;

        int value = preorder[idx], pos = left;
        while(inorder[pos] != value) pos++;

        TreeNode root = new TreeNode(value);
        root.left = recursion(preorder, inorder, left, pos-1, idx+1);
        root.right = recursion(preorder, inorder, pos+1, right, idx+pos-left+1);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}