// 129. Sum Root to Leaf Numbers

public class SumRootToLeafNumbers {
	
	public void run() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);

        node4.left = node9;
        node4.right = node0;

        node9.left = node5;
        node9.right = node1;

        System.out.println(sumNumbers(node4));
    }

    public int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    private int recursion(TreeNode root, int num) {
        if(root == null) return 0;

        num = num * 10 + root.val;

        if(root.left == null && root.right == null) return num;
        return recursion(root.left, num) + recursion(root.right, num);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}