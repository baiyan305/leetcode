// 113. Path Sum II

public class PathSumII {
	
	public void run() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        node5.left = node4;
        node5.right = node8;

        TreeNode node11 = new TreeNode(11);
        node4.left = node11;

        TreeNode node13 = new TreeNode(13);
        TreeNode node41 = new TreeNode(4);
        node8.left = node13;
        node8.right = node41;

        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node11.left = node7;
        node11.right = node2;

        TreeNode node51 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node41.left = node51;
        node41.right = node1;

        System.out.println(pathSum(node5, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(root, sum, lists, new ArrayList<>());
        return lists;
    }

    private void backtracking(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        if(root.left != null) backtracking(root.left, sum, lists, list);
        if(root.right != null) backtracking(root.right, sum, lists, list);
        list.remove(list.size()-1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}