// 199. Binary Tree Right Side View

public class BinaryTreeRightSideView {
	
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

        System.out.println(rightSideView(node4));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(i == 0) list.add(node.val);
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
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