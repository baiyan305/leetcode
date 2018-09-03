// 623. Add One Row to Tree

public class AddOneRowToTree {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        TreeNode root = addOneRow(node1, 5, 4);

        System.out.println();
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        recursion(root, v, d, 1);
        return root;
    }

    private void recursion(TreeNode root, int v, int d, int depth) {
        if(root == null) return ;

        if(depth == d-1) {
            TreeNode left = root.left, right = root.right;
            TreeNode newLeft = new TreeNode(v), newRight = new TreeNode(v);
            root.left = newLeft;
            newLeft.left = left;
            root.right = newRight;
            newRight.right = right;
        }

        recursion(root.left, v, d, depth+1);
        recursion(root.right, v, d, depth+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}