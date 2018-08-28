// 366. Find Leaves of Binary Tree

public class FindLeavesOfBinaryTree {

    public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(findLeaves(node1));
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        recursion(root, lists);
        return lists;
    }

    private int recursion(TreeNode root, List<List<Integer>> lists) {
        if(root == null) return -1;

        int height = 1 + Math.max(recursion(root.left, lists), recursion(root.right, lists));
        if(height >= lists.size())lists.add(0, new ArrayList<>());
        lists.get(lists.size()-height-1).add(root.val);

        return height;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
