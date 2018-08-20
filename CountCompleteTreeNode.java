// 222. Count Complete Tree Nodes

public class CountCompleteTreeNode {
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

        System.out.println(countNodes(node4));
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftH = 0, rightH = 0;
        TreeNode left = root, right = root;
        while(left != null) {
            leftH++;
            left = left.left;
        }
        while(right != null){
            rightH++;
            right =  right.right;
        }

        if(leftH == rightH)  return (int)Math.pow(2, leftH) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}