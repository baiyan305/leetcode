// 270. Closest Binary Search Tree Value

public class ClosestBinarySearchTreeValue {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node4.left = node2;
        node4.right = node5;

        node2.left = node1;
        node2.right = node3;

        System.out.println(closestValue(node4, 3.714286));
    }

    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null) {
            if(Math.abs(target-root.val) < Math.abs(target-res)) res = root.val;
            root = target >= root.val ? root.right : root.left;
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}