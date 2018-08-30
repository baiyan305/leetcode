// 285. Inorder Successor in BST

public class InorderSuccessorInBST {
	
	public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        TreeNode successor = inorderSuccessor(node5, node6);
        System.out.println(successor.val);
    }

	// 其实就是找到smallest element larger than p.val
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;

        while(root != null) {
			// 如果当前node值比p值大，那么答案一定是node自己或者左子树中的点
            if(p.val < root.val){
                pre = root;
                root = root.left;
            } 
			else 
			// 如果当前node值大于等于p.val, 有两种情况
		    // 1. node.right是空，那么答案就是pre
			// 2. node.right不为空，那么答案一定在右子树中
			// 这两种情况都可以用 root=root.right 覆盖
			{
                root = root.right;
            }
        }

        return pre;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
}