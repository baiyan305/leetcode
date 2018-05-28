// 11. Container With Most Water
// 


public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		
	}
	
	public int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
		int max = 0, left = 0, right = height.length - 1;
		
		while(left<right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right-left));
			if(height[left] < height[right]) left++;
			else if(height[left] > height[right) right--;
			else {
				left++;
				right--;
			}
		}
		
		return max;
    }
	
}