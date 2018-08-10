// 145. Binary Tree Postorder Traversal

public class BinaryTreePostorderTraversal {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(postorderTraversal(node1));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode prev = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();
            if(node.right != null && node.right != prev) { // 右子树还没有遍历过
                root = node.right;
            } else { // 右子树已经遍历过
                list.add(node.val);
                stack.pop();
                prev = node;
            }
        }

        return list;
    }

    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode prev = new TreeNode(-1);
        prev.left = root;
        while(!stack.isEmpty() || root != null) {
            if(root == null) {
                prev = root;
                root = stack.pop();
            } else {
                if(prev != null) {
                    if(root.left == prev) {
                        stack.push(root);
                        prev = root;
                        root = root.right;
                    } else if(root.right == prev) {
                        list.add(root.val);
                        prev = root;
                        root = stack.isEmpty() ? null : stack.pop();
                    } else {
                        stack.push(root);
                        prev = root;
                        root = root.left;
                    }
                } else {
                    if(root.left == null && root.right == null) {
                        list.add(root.val);
                        prev = root;
                        root = stack.isEmpty() ? null : stack.pop();
                    } else if(root.left == null) {
                        stack.push(root);
                        prev = root;
                        root = root.right;
                    } else {
                        list.add(root.val);
                        prev = root;
                        root = stack.isEmpty() ? null : stack.pop();
                    }
                }
            }
        }

        return list;
    }
    */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}