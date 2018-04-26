// 10. Regular Expression Matching

public class RegularExpressionMatching {

    public static void main(String args[]) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;

        for(int i=1; i<dp.length; i++)
            if(p.charAt(i-1) == '*')
                dp[i][0] = dp[i-2][0];

        int height = p.length(), width = s.length();
        for(int h=1; h<=height; h++) {
            for(int w=1; w<=width; w++) {
                if(p.charAt(h-1) == '*') { //当前位置是星号
                    if(p.charAt(h-2) == s.charAt(w-1) || p.charAt(h-2) == '.') { //匹配
                        dp[h][w] = dp[h-2][w] || dp[h-2][w-1] || dp[h][w-1];
                    } else { //不匹配
                        dp[h][w] = dp[h-2][w];
                    }
                } else if(p.charAt(h-1) == '.' || p.charAt(h-1) == s.charAt(w-1)) { //当前位置不是星号
                    dp[h][w] = dp[h-1][w-1];
                }
            }
        }

        return dp[height][width];
    }

    /*recursion
    public static boolean isMatch(String s, String p) {
        if(s == "" && p == "") return true;
        if(s != "" && p == "") return false;
        

        if(p.length()>=2 && p.charAt(1)=='*') {
            if(s != "" && s.charAt(0) == p.charAt(0) || p.charAt(0)=='.')
                return isMatch(s.substring(1), p);
            else
                return isMatch(s, p.substring(2));
        } else if(s != "" && s.charAt(0) == p.charAt(0) || p.charAt(0)=='.'){
            return isMatch(s.substring(1), p.substring(1));
        }

        return false;    
    }
    */
}
