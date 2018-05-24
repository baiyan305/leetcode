// 410. Split Array Largest Sum

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }

    public static int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m];   
        dp[0][0] = nums[0];
        for(int i=1; i<nums.length; i++) dp[i][0] = nums[i] + dp[i-1][0];

        for(int col=1; col<m; col++) {
            for(int row=col; row<nums.length; row++) {
                int sum = 0;
                for(int i=row; i>col; i--) {
                    sum += nums[i];
                    int tmp = Math.max(sum, dp[i-1][col-1]);
                    dp[row][col] = dp[row][col]==0 ? tmp : Math.min(dp[row][col], tmp); 
                } 
            }
        }

        return dp[nums.length-1][m-1];
    }

}
