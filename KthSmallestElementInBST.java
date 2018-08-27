// 230. Kth Smallest Element in a BST

public class KthSmallestElementInBST {

    public void run() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;

        node1.right = node2;


        System.out.println(kthSmallest(node3, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(++count == k) return root.val;
            root = root.right;
        }

        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
