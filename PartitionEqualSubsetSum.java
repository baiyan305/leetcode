// 416. Partition Equal Subset Sum

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		System.out.println(canPartition(nums));
	}


	// 二维DP
    // 这道题需要将数组分成两部分，他们的和相同。
    // 这套题的思路可以简化。首先求出数组所有元素的和sum。
    // 如果这个数组可以被分成和相同的两部分，那么每个部分的值一定是sum除以2。
    // 所以这个题就转化为，能否找出和为sum/2的子数组。
    //
    // 最简单的方法是DFS，对于每一个元素有两个选择，选择这个元素或者不选择这个元素。
    // 这个方法有大量重复计算。
    //
    // 二维的DP:  boolean[i][j], 表示前i个元素是否含有和为j的子数组。
    // 这个二维DP其实可以转化为一维的DP。因为在二维矩阵中，每一行求值时，只需要前面一行的数据。
    // 所以不需要维护二维矩阵。
	public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num; // 求数组元素的和
        if(sum % 2 != 0) return false; // 和必须是偶数，才能被分成和相同的两部分。
        sum = sum/2; // sum除以2，就是我们需要找的目标和

        boolean[][] dp = new boolean[nums.length][sum+1];
        // 前0个元素，是否有和为i的子数组。只要第一个元素等于sum, 就是true。
        for(int i=0; i<=sum; i++) dp[0][i] = nums[0] == i ? true : false ;
        // 看前i个元素，是否有和为0的子数组。一定有，空数组就可以了。
        for(int i=0; i<nums.length; i++) dp[i][0] = true;

        // 填充二维DP的matrix
        for(int i=1; i<nums.length; i++) { // i is the index of number
            for(int j=1; j<=sum; j++) { // j is the sum
                // 如果不使用这个nums[i], 那么dp[i][j] = dp[i-1][j]
                // 如果使用nums[i], 那么dp[i][j] = dp[i-1][j-nums[i]]
                dp[i][j] = dp[i-1][j] || (j>=nums[i] ? dp[i-1][j-nums[i]] : false);
            }
        }

        return dp[nums.length-1][sum];
    }
	
}