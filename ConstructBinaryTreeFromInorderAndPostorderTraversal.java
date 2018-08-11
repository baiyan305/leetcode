// 106. Construct Binary Tree from Inorder and Postorder Traversal

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public void run() {
        int[] postorder = {8,9,4,10,5,2,11,12,6,13,7,3,1}, inorder = {8,4,9,2,5,10,1,11,6,12,3,13,7};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("123");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(inorder,postorder,0,inorder.length-1,inorder.length-1);
    }

    private TreeNode recursion(int[] inorder, int[] postorder, int left, int right, int idx) {
        if(left>right) return null;

        int value = postorder[idx], pos = right;
        while(inorder[pos] != value) pos--;

        TreeNode root = new TreeNode(value);
        root.left = recursion(inorder, postorder, left, pos-1, idx-(right-pos)-1);
        root.right = recursion(inorder, postorder, pos+1, right, idx-1);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}