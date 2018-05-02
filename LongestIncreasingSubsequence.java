// 300. Longest Increasing Subsequence

import java.util.Arrays;

public class LongestIncreasingSubsequence{

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(arr));
    }

	public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
		int len = 0;
		for(int num : nums) {
			int start = 0, end = len;
			while(start<end) {
				int mid = (end+start)/2;
				if(num > dp[mid])
					start = mid+1;
				else
					end = mid;	
			}
			
			dp[start] = num;
			if(start==len) ++len;;
		}
		
		return len;
    }
	/*
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<nums.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
	*/
}