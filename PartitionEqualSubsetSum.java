// 416. Partition Equal Subset Sum

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		System.out.println(canPartition(nums));
	}
	
	public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        sum = sum/2;

        boolean[][] dp = new boolean[nums.length][sum+1];
        for(int i=0; i<=sum; i++) dp[0][i] = nums[0] == i ? true : false ;
        for(int i=0; i<nums.length; i++) dp[i][0] = true;

        for(int i=1; i<nums.length; i++) { // i is the index of number
            for(int j=1; j<=sum; j++) { // j is the sum
                //System.out.println("i:"+i+", j:"+j);
                dp[i][j] = dp[i-1][j] || (j>=nums[i] ? dp[i-1][j-nums[i]] : false);
            }
        }

        return dp[nums.length-1][sum];
    }
	
}