package yan.bai;

import java.util.LinkedList;
import java.util.List;

public class AllNodesDistanceKBinaryTree {

    public static void main(String[] args) {
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new LinkedList<Integer>();
        findTarget(root, target, K, list);
        return list;
    }

    private int findTarget(TreeNode root,TreeNode target, int K, List<Integer> list) {
        if(root == null) return -1;

        if(root.val == target.val) {
            searchChild(root, K, 0, list);
            return 1;
        }

        int leftResp = findTarget(root.left, target, K, list);
        if(leftResp != -1) { //target node is in left substree
            if(leftResp == K) list.add(root.val);
            searchChild(root.right, K-leftResp-1, 0, list);
            return leftResp+1;
        }
        int rightResp = findTarget(root.right, target, K, list);
        if(rightResp != -1) { //target node is int right substree
            if(rightResp == K) list.add(root.val);
            searchChild(root.left, K-rightResp-1, 0, list);
            return rightResp+1;
        }

        return -1;
    }

    private void searchChild(TreeNode root, int target, int depth, List<Integer> list) {
        if(root == null || depth > target) return;
        if(depth == target) list.add(root.val);

        searchChild(root.left, target, depth+1, list);
        searchChild(root.right, target, depth+1, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
