// 312. Burst Balloons

public class BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(maxCoins(nums)); 
    }

    public static int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length];

        for(int len=1; len<=nums.length; len++) {
            for(int left=0; left+len<=nums.length; left++) {
                int right = left + len - 1;
                for(int i=left; i<=right; i++) {
                    int leftNum = left-1==-1 ? 1 : nums[left-1];
                    int rightNum = right+1==nums.length ? 1 : nums[right+1];
                    int leftPart = i-1 < left ? 0 : dp[left][i-1];
                    int rightPart = i+1 > right ? 0 : dp[i+1][right];

                    dp[left][right] = Math.max(dp[left][right], nums[i] * (left-1==-1 ? 1 : nums[left-1]) * (right+1==nums.length ? 1 : nums[right+1]) + (i-1 < left ? 0 : dp[left][i-1]) + (i+1 > right ? 0 : dp[i+1][right]) );                         
                }
            }
        }

        return dp[0][nums.length-1];
    }

}
