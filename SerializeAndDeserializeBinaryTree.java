// 297. Serialize and Deserialize Binary Tree

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public void run() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        Codec codec = new Codec();
        String str = codec.serialize(node1);
        System.out.println(str);
        TreeNode root = codec.deserialize(str);
        System.out.println(root.val);

    }

    public class Codec {

        private final String NULL = "X";
        private final String SPLIT = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            buildString(root, builder);
            return builder.length() == 0 ? builder.toString() : builder.substring(0, builder.length()-1).toString();
        }

        private void buildString(TreeNode root, StringBuilder builder) {
            if(root == null){
                builder.append(NULL).append(SPLIT);
            } else {
                builder.append(root.val).append(SPLIT);
                buildString(root.left, builder);
                buildString(root.right, builder);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPLIT)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Queue<String> nodes) {
            String str = nodes.poll();
            if(str.equals(NULL)) return null;

            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
