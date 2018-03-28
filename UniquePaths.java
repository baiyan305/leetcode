// 62. Unique Paths

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++){
                dp[col]=dp[col]+dp[col-1];
            }
        }

        return dp[n-1];
    }

}