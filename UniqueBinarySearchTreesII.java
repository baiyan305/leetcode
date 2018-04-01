// 95. Unique Binary Search Trees II

class UniqueBinarySearchTreesII {
	
	public static void main(String[] args) {
		
	}
	
	public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
	
	private static List<TreeNode> helper(int left, int right) {
		List<TreeNode> nodes = new ArrayList<>();
		
		// when to quit the recursion
		if(left>right){
			nodes.add(null);
			return nodes;
		}
		
		for(int i=left; i<=right; i++) {
			List<TreeNode> leftTree = helper(left, i-1);
			List<TreeNode> rightTree = helper(i+1, right);
			
			for(int j=0; j<leftTree.size(); j++) {
				for(int k=0; k<rightTree.size(); k++) {
					TreeNode node = new TreeNode(i);
					node.left = leftTree.get(j);
					node.right = rightTree.get(k);
					nodes.add(node);
				}
			}
			
		}
		
		return nodes;
	}
	
}