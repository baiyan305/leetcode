// 279. Perfect Squares

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
            int max = (int)Math.sqrt(i);
            for(int j=1; j<=max; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }

    /*
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            if(isSquare(i)) {
                dp[i] = 1;
                continue;
            }

            for(int j=i-1; j>=(i/2); j--) {
                dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
            }

        }

        return dp[n];
    }

    public static boolean isSquare(int num) {
        double sqrt = Math.sqrt(num);
        int m = (int) sqrt;
        return m * m == num;
    }
    */
}

