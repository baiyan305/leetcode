// 652. Find Duplicate Subtrees

public class FindDuplicateSubtrees {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node21 = new TreeNode(2);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node21;
        node3.right = node41;

        node21.left = node42;


        List<TreeNode> list = findDuplicateSubtrees(node1);

        System.out.println();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new LinkedList<>();
        recursion(root, map, list);

        return list;
    }

    private String recursion(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
        if(root == null) return "#";

        String serial = "(" + root.val + "," + recursion(root.left, map, list) + "," + recursion(root.right, map, list) + ")";
        if(map.getOrDefault(serial, 0) == 1) list.add(root);
        map.put(serial, map.getOrDefault(serial, 0)+1);

        return serial;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}