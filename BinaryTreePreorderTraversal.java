// 144. Binary Tree Preorder Traversal

public class BinaryTreePreorderTraversal {

	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(preorderTraversal(node1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root != null) stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            while(root != null) {
                if(root.right != null) stack.push(root.right);
                list.add(root.val);
                root = root.left;
            }
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}