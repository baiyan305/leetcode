// 368. Largest Divisible Subset

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0) return list;

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        
        int max = 1, maxIdx = 0;
        for(int i=0; i<len; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if(dp[i] > max) {
				maxIdx = i;
				max = dp[i];
			}
        }

		int count =  dp[maxIdx];
		for(int i=maxIdx; i>=0; i--) {
			if(nums[maxIdx]%nums[i] == 0 && dp[i] == count){
				list.add(0, nums[i]);
				count--;
			}
		}
        
		return list;
    }

}