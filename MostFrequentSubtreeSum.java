// 508. Most Frequent Subtree Sum

import java.util.HashMap;

public class MostFrequentSubtreeSum {

    public void run() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);

        node5.left = node2;
        node5.right = node3;

        int[] ret = findFrequentTreeSum(node5);

        System.out.println(123);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        recursion(root, map);

        int max = 0, times = 0;
        for(int value : map.values()) max = Math.max(max, value);
        for(int value : map.values()) if(value == max) times++;

        int[] ret = new int[times];
        int i = 0;
        for(int key : map.keySet()) if(map.get(key) == max) ret[i++] = key;

        return ret;
    }

    private int recursion(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return 0;

        int sum = root.val + recursion(root.left, map) + recursion(root.right, map);
        if(!map.containsKey(sum)) map.put(sum, 0);
        map.put(sum, map.get(sum)+1);

        return sum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
