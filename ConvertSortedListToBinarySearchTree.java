// 109. Convert Sorted List to Binary Search Tree

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode[] node = new ListNode[]{head};
        return sortedListToBST(node, 0, length(head)-1);
    }

    // 这道题好难解释啊，需要抽象思维和图形想象力
    // 思路是先构建左子树，之后node前进一个
    // start初始等于0，end是len-1
    // 当start<=mid时候，说明左子树还没构建完，要继续构建左子树
    // 如果start>end，说明左子树没有了，那么构建root, 之后构建右子数
    private TreeNode sortedListToBST(ListNode[] node, int start, int end) {
        if(start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode left = sortedListToBST(node, start, mid-1);
        TreeNode root = new TreeNode(node[0].val);
        node[0] = node[0].next;
        TreeNode right = sortedListToBST(node, mid+1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    private int length(ListNode head) {
        int len =0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
