// 53. Maximum Subarray

public class MaximumSubarray {
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
		
		int global = nums[0], local = nums[0];
		for(int i=1; i<nums.length; i++) {
			local = nums[i] + (local < 0 ? 0 : local);
			global = Math.max(global, local);
		}
		
		return global;
    }
	
}