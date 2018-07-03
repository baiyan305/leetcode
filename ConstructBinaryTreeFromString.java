// 536. Construct Binary Tree from String

public class ConstructBinaryTreeFromString {
	
	public static void main(String[] args) {
		TreeNode root1 = str2tree("4(2(3)(1))(6(5))");
		TreeNode root2 = str2tree("3");
		TreeNode root3 = str2tree("");
		System.out.println("123");
	}
	
	public static TreeNode str2tree(String s) {
		return recursion(s, 0, s.length()-1);
	}
	
	// Recursion
	private static TreeNode recursion(String s, int left, int right) {
		if(left > right) return null;
		
		//parent node
		int idxOfFirstLeft = left;
		while(idxOfFirstLeft<=right && s.charAt(idxOfFirstLeft)!='(') idxOfFirstLeft++;
		if(idxOfFirstLeft > right) return new TreeNode(Integer.parseInt(s.substring(left, right+1)));
		
		int parentValue = Integer.parseInt(s.substring(left, idxOfFirstLeft));
		TreeNode parent = new TreeNode(parentValue);
		
		int numOfLeft = 1, numOfRight = 0, idx = idxOfFirstLeft+1;
		
		//left child node
		while(numOfLeft != numOfRight) {
			if(s.charAt(idx) == '(') numOfLeft++;
			else if(s.charAt(idx) == ')') numOfRight++;
			idx++;
		}
		parent.left = recursion(s, idxOfFirstLeft+1, idx-2);
		
		//right child node
		if(idx <= right) {
			parent.right = recursion(s, idx+1, right-1);
		}
		
		return parent;
	}
	
	// Stack
	/*
	public static TreeNode str2tree(String s) {
		Stack<TreeNode> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		
		for(char ch : s.toCharArray()) {
			switch(ch){
				case '(':
					if(builder.length() != 0) {
						stack.push(new TreeNode(Integer.parseInt(builder.toString())));
						builder.setLength(0);
					}
					break;
				case ')':
					TreeNode child = null;
					if(builder.length()!= 0) {
						child = new TreeNode(Integer.parseInt(builder.toString()));
						builder.setLength(0);
					} else {
						child = stack.pop();
					}
					TreeNode father = stack.peek();
					if(father.left == null) father.left = child;
					else father.right = child;
					break;
				default:
					builder.append(ch);
					break;
			}
		}
		
		return stack.isEmpty() ? null : stack.peek();
    }
	*/
	
}