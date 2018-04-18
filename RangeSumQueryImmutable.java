// 303. Range Sum Query - Immutable

public class RangeSumQueryImmutable {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		NumArray obj = new NumArray(nums);
	}
	
	
	static class NumArray {

		int[]sums = null;
		
		public NumArray(int[] nums) {	
			sums = new int[nums.length];
			sums[0] = nums[0];
			
			for(int i=1; i<nums.length; i++)
				sums[i] = sums[i-1] + nums[i];				
		}
		
		public int sumRange(int i, int j) {
			return i==0 ? sums[j] : sum[j] - sum[i-1];
		}
	}
	
}