// 84. Largest Rectangle in Histogram

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public static void main(String[] args) {
		int[] heights = new int[]{2,1,5,6,2,3};
		//int[] heights = new int[]{1,2,3};
		//int[] heights = new int[]{2,1,2};
		//int[] heights = new int[]{4,2,0,3,2,5};
		System.out.println(largestRectangleArea(heights));
	}
	
	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		
		for(int i=0; i<=heights.length; i++) {
			int height = i == heights.length ? 0 : heights[i];
			if(!stack.isEmpty() && height < heights[stack.peek()]){
				while(!stack.isEmpty() && height < heights[stack.peek()]){
					int baseIdx = stack.pop();
					int left = stack.isEmpty() ? -1 : stack.peek();
					max = Math.max(max, heights[baseIdx] * (i-1-left));
				}
			} 
            
			stack.push(i);
		}
		/*
		int rightMostIdx = stack.isEmpty() ? 0 : stack.peek();
		while(!stack.isEmpty()) {
			int baseIdx = stack.pop();
			int leftIdx = stack.isEmpty() ? -1 : stack.peek();
			max = Math.max(max, heights[baseIdx] * (rightMostIdx - leftIdx));
		}
		*/
		return max;
    }
	
}