// 894. All Possible Full Binary Trees

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        // N肯定是奇数, 比如1,3,5,7,9
        if(N%2 == 0)
            return new ArrayList<>();

        // HashMap记录，Node数量对应的 所有可能的树
        // 比如:
        //   1个node, 只有一种情况
        //   3个node, 只有一种情况，左1右1
        //   5个node, 有两种情况, 左1右3，左3右1
        //   7个node, 有三种情况，左1右5，左3右3，左5右1
        //
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();

        // 初始化，只有一个node情况
        List<TreeNode> init = new ArrayList<>();
        init.add(new TreeNode(0));
        map.put(1, init);

        // 遍历3到N, 只看奇数
        for(int k=3; k<=N; k+=2) {
            map.put(k, new ArrayList<>());

            //左树的node个数，从1到k-2， -2是因为一个root,一个右树
            for(int left=1; left<= k-2; left+=2) {
                // 右树的node个数
                int right = k-left-1;
                // 左树的所有可能树
                for(TreeNode lNode : map.get(left)) {
                    // 右树的所有可能树
                    for(TreeNode rNode: map.get(right)) {
                        // 形成新的树
                        TreeNode root = new TreeNode(0);
                        root.left = lNode;
                        root.right = rNode;
                        map.get(k).add(root);
                    }
                }
            }
        }

        return map.get(N);
    }

}
