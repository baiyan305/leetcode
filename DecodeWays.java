// 91. Decode Ways

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("19"));
        System.out.println(numDecodings("1"));
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("129"));
        System.out.println(numDecodings("1209"));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        s = "00" + s;
        int prev1 = 0, prev2 = 1;

        for(int i=2; i<s.length(); i++) {
            int ways = 0;
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9') ways += prev2;
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) ways += prev1;
            prev1 = prev2;
            prev2 = ways;
        }
        
        return prev2;
    }

    /*
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')  return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=len; i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(oneDigit >=1 && oneDigit <=9) dp[i] += dp[i-1];
            if(twoDigit >=10 && twoDigit <= 26) dp[i] += dp[i-2];
        }

        return dp[len];
    }
    */
}