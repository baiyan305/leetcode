public class ClosestBinarySearchTreeValueII {
	
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

        System.out.println(closestKValues(node4, 3.714286, 2));
    }

	// 递归
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        recursion(list, root, target, k);

        return list;
    }

    private boolean recursion(List<Integer> list, TreeNode root, double target, int k) {
        if(root == null) return false;

        recursion(list, root.left, target, k);

        if(list.size() < k){
            list.add(root.val);
        } else {
            if(Math.abs(root.val-target) < Math.abs(list.get(0)-target) ){
                list.add(root.val);
                list.remove(0);
            } else {
                return true;
            }
        }

        return recursion(list, root.right, target, k);
    }

    /* 栈
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();

        // Inorder traversal
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(list.size() < k){
                list.add(root.val);
            } else {
                if(Math.abs(root.val-target) < Math.abs(list.get(0)-target) ){
                    list.add(root.val);
                    list.remove(0);
                } else {
                    break;
                }
            }

            root = root.right;
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