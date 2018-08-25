// 333. Largest BST Subtree

public class LargestBSTSubtree {

    public void run() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);

        node10.left = node5;
        node10.right = node15;

        node5.left = node1;
        node5.right = node8;

        node15.right = node7;

        System.out.println(largestBSTSubtree(node10));
    }

    public int largestBSTSubtree(TreeNode root) {
        int[] longest = new int[1];
        recursion(root, longest);

        return longest[0];
    }

    private int[] recursion(TreeNode root, int[] longest) {
        if(root == null) return new int[]{0, 0, 0};

        int[] leftRet = recursion(root.left, longest);
        int[] rightRet = recursion(root.right, longest);
        int[] ret = new int[]{1, root.val, root.val};

        // not a BST, return directly
        if(leftRet[0] < 0
                || rightRet[0] < 0
                || (leftRet[0] != 0 && root.val <= leftRet[1])
                || (rightRet[0] != 0 && root.val >= rightRet[2])
                ) {
            ret[0] = -1;
            return ret;
        }

        ret[0] += (leftRet[0]+rightRet[0]);
        ret[1] = rightRet[0] == 0 ? root.val : rightRet[1];
        ret[2] = leftRet[0] == 0 ? root.val : leftRet[2];

        longest[0] = Math.max(longest[0], ret[0]);

        return ret;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
