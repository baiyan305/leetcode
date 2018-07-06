// 647. Palindromic Substrings

public class PalindromicSubstrings{

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int ret = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int span=0; span<len; span++) {
            for(int start=0; start+span<len; start++) {
                int end = start+span;
                if(start == end) dp[start][end] = true;
                else if(s.charAt(start) == s.charAt(end)) dp[start][end] = start+1 == end ? true : dp[start+1][end-1];

                if(dp[start][end]) ret++;
            }
        }

        return ret;
    }


}
