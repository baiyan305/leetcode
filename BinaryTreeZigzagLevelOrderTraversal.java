// 103. Binary Tree Zigzag Level Order Traversal

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public void run() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(zigzagLevelOrder(node3));
    }

    // BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stackOdd = new Stack<>(), stackEven = new Stack<>();
        if(root != null) stackEven.push(root);

        int level = 0;
        while(!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            if(level %2 == 0) {
                while(!stackEven.isEmpty()) {
                    TreeNode node = stackEven.pop();
                    list.add(node.val);
                    if(node.left!=null) stackOdd.push(node.left);
                    if(node.right!=null) stackOdd.push(node.right);
                }
            } else {
                while(!stackOdd.isEmpty()) {
                    TreeNode node = stackOdd.pop();
                    list.add(node.val);
                    if(node.right!=null) stackEven.push(node.right);
                    if(node.left!=null) stackEven.push(node.left);
                }
            }

            lists.add(list);
            level++;
        }

        return lists;
    }

    /* DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        recursion(root, 0, lists);

        return lists;
    }

    private void recursion(TreeNode root, int level, List<List<Integer>> lists) {
        if(root == null) return;

        if(level >= lists.size()) lists.add(new ArrayList<>());
        if(level %2 == 0) {
            lists.get(level).add(root.val);
        } else {
            lists.get(level).add(0, root.val);
        }

        recursion(root.left, level+1, lists);
        recursion(root.right, level+1, lists);
    }
    */
	
}