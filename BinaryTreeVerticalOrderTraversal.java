// 314. Binary Tree Vertical Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

    public void run() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node3.left = node9;
        node3.right = node8;

        node9.left = node4;
        node9.right = node0;

        node8.left = node1;
        node8.right = node7;

        node0.right = node2;

        node1.left = node5;

        System.out.println(verticalOrder(node3));
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> widthQueue = new LinkedList<>();
        if(root != null) {
            nodeQueue.add(root);
            widthQueue.add(0);
            lists.add(new ArrayList<>());
        }

        int min = 0, max = 0;
        while(!nodeQueue.isEmpty()) {
            int width = widthQueue.poll();
            if(width<min) {
                lists.add(0, new ArrayList<>());
                min--;
            } else if(width>max) {
                lists.add(new ArrayList<>());
                max++;
            }

            TreeNode node = nodeQueue.poll();
            lists.get(width-min).add(node.val);

            if(node.left!=null) {
                nodeQueue.add(node.left);
                widthQueue.add(width-1);
            }
            if(node.right!=null) {
                nodeQueue.add(node.right);
                widthQueue.add(width+1);
            }
        }

        return lists;
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
