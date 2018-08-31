// 450. Delete Node in a BST

public class DeleteNodeInBST{

    public void run() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node6.right = node7;

        TreeNode newRoot = deleteNode(node5, 3);
        System.out.println(123);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        TreeNode newRoot = root;
        if(root.val == key) {
            newRoot = root.left != null ? root.left : root.right != null ? root.right : null;

            if(root.left != null && root.right != null) {
                TreeNode smallestInRight = root.right;
                while(smallestInRight.left != null) smallestInRight = smallestInRight.left;
                smallestInRight.left = newRoot.right;

                newRoot.right = root.right;
            }

            root.left = null;
            root.right = null;
        }

        if(newRoot != null) {
            newRoot.left = deleteNode(newRoot.left, key);
            newRoot.right = deleteNode(newRoot.right, key);
        }

        return newRoot;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
