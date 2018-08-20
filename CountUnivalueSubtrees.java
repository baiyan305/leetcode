// 250. Count Univalue Subtrees

public class CountUnivalueSubtrees {

    public void run() {
        TreeNode node51 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node52 = new TreeNode(5);

        node51.left = node1;
        node51.right = node52;

        TreeNode node53 = new TreeNode(5);
        TreeNode node54 = new TreeNode(5);

        node1.left = node53;
        node1.right = node54;

        TreeNode node55 = new TreeNode(5);

        node52.right = node55;

        System.out.println(countUnivalSubtrees(node51));
    }

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode root, int[] count) {
        if(root == null) return true;

        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if(left && right && (root.left == null || (root.val == root.left.val)) && (root.right == null || (root.val == root.right.val))) {
            count[0]++;
            return true;
        }

        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
