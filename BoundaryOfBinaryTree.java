// 545. Boundary of Binary Tree

public class BoundaryOfBinaryTree {
	
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

        System.out.println(boundaryOfBinaryTree(node5));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        list.add(root.val);
        leftBoundary(root.left, list);
        leaves(root.left, list);
        leaves(root.right, list);
        rightBoundary(root.right, list);

        return list;
    }

    private void leftBoundary(TreeNode root, List<Integer> list) {
        if(root == null || (root.left==null && root.right==null)) return;

        list.add(root.val);
        if(root.left != null) leftBoundary(root.left, list);
        else leftBoundary(root.right, list);
    }

    private void rightBoundary(TreeNode root, List<Integer> list) {
        if(root == null || (root.left==null && root.right==null)) return;

        if(root.right != null) rightBoundary(root.right, list);
        else rightBoundary(root.left, list);

        list.add(root.val);
    }

    private void leaves(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left==null && root.right==null) {
            list.add(root.val);
            return;
        }

        leaves(root.left, list);
        leaves(root.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}