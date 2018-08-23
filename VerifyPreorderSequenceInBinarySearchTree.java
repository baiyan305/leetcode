public class VerifyPreorderSequenceInBinarySearchTree {

    public void run() {
        TreeNode node51 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node52 = new TreeNode(5);

        node51.left = node1;
        node51.right = node52;

        TreeNode node53 = new TreeNode(5);
        TreeNode node54 = new TreeNode(5);

        node1.left = node53;
        node1.right = node54;

        TreeNode node55 = new TreeNode(5);

        node52.right = node55;

        int[] arr1 = {5,2,6,1,3};
        int[] arr2 = {5,2,1,3,6};
        System.out.println(verifyPreorder(arr1)); //false
        System.out.println(verifyPreorder(arr2)); //true
    }

    // 从BST最小值遍历到最大值，新的值不能比之前的值小
    // 参考 98. Validate Binary Search Tree
    public boolean verifyPreorder(int[] preorder) {
        Integer prev = null, stackIdx = 0;
        for(int i : preorder) {
            if(prev != null && i<= prev) return false;

            while(stackIdx > 0 && i > preorder[stackIdx-1]) {
                prev = preorder[--stackIdx];
            }

            preorder[stackIdx++] = i;
        }

        return true;
    }

    /*
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;

        Stack<Integer> stack = new Stack<>();
        Integer prev = null;
        for(int i : preorder) {
            if(prev != null && i<= prev) return false;

            while(!stack.isEmpty() && i > stack.peek()) {
                prev = stack.pop();
            }

            stack.push(i);
        }

        return true;
    }
    */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
