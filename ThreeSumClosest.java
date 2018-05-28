// 16. 3Sum Closest

import java.util.Arrays;

public class ThreeSumClosest {
	
	public static void main(String[] args) {
		//int[] nums = {1,2,4,8,16,32,64,128};
		int[] nums = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(nums, 1));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int len = nums.length;
        if(target <= nums[0]+nums[1]+nums[2]) return nums[0]+nums[1]+nums[2];
		if(target >= nums[len-1]+nums[len-2]+nums[len-3]) return nums[len-1]+nums[len-2]+nums[len-3];
		
		int closestSum = nums[0]+nums[1]+nums[2];
		for(int num1=0; num1<len-2; num1++) {
			int left = num1 + 1;
			int right = len - 1;
			while(left<right) {
				int sum = nums[num1]+nums[left]+nums[right];
				
				if(sum == target) return sum;
				if(Math.abs(target-sum) < Math.abs(target-closestSum)) closestSum = sum;
				
				if(sum < target) left++;
				else right--;
			}
		}
		
		return closestSum;
    }
	
}