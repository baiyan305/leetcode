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
            // 对于每一个数字，比较它本身和它本身+前面的最大和subarray
            // 比如4,-5,6
            // 比如对于6，它之前的subarray最大和是-1，那么6开始就重新开始了，抛弃之前的-1.
			local = nums[i] + (local < 0 ? 0 : local);
			global = Math.max(global, local);
		}
		
		return global;
    }
    
    /* Divide and conquer
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    
    private int divide(int[] nums, int left, int right) {
        if(left >= right) return nums[left];
        
        int mid = left+(right-left)/2;

        // 先求出左，右半部分的最大subarry
        int leftMax = divide(nums, left, mid-1);
        int rightMax = divide(nums, mid+1, right);
        
        // nums[i]向两边延伸出去的最大值
        int sum = 0, lmax = 0, rmax = 0;
        for(int i=mid-1; i>=left; i--) {
            sum += nums[i];
            lmax = Math.max(lmax, sum);
        }
        sum = 0;
        for(int i=mid+1; i<=right; i++) {
            sum += nums[i];
            rmax = Math.max(rmax, sum);
        }
        
        return Math.max(lmax+rmax+nums[mid], Math.max(leftMax, rightMax));
    }
    */	
}
