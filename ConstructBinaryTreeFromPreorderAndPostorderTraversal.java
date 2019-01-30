// 889. Construct Binary Tree from Preorder and Postorder Traversal

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> postMap = new HashMap<>();
        for(int i=0; i<post.length; i++) postMap.put(post[i], i);
        
        return build(postMap, pre, 0, pre.length-1);
    }
    
    
    //      1
    //   2     3
    //  4 5   6 7
    //
    // Preorder:  1,2,4,5,3,6,7
    // Postorder: 4,5,2,6,7,3,1
    // 
    // Preorder:  root <left> <right>
    // Postorder: <left> <right> root
    //
    // 先看Preorder中的第一个元素，和它后面的元素
    // 第一个元素一定是Root, 它后面有两种情况：
    // 1.有左树和右树
    // 2.只有左树或右树
    // 我们在Postorder中，找到root元素和第二个元素的位置(pos)
    //  1.如果第二个元素的位置紧挨着root元素，说明只有左树或右树
    //  2.如果不紧挨着，那么pos和root元素之间的部分就是右树
    private TreeNode build(HashMap<Integer, Integer> post, int[] pre, int start, int end) {
        if(start == end) return new TreeNode(pre[start]);
        
        TreeNode root = new TreeNode(pre[start]);
        int rightSize = post.get(pre[start])-post.get(pre[start+1])-1;
        if(rightSize != 0)
            root.right = build(post, pre, end-rightSize+1, end);
        
        root.left = build(post, pre, start+1, end-rightSize);
        return root;
    }

}
