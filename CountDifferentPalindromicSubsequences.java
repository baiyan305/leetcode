// 730. Count Different Palindromic Subsequences

public class CountDifferentPalindromicSubsequences{

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("bccb"));
        System.out.println(countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

    // DP
    public static int countPalindromicSubsequences(String S) {
        int total = S.length();
        int[][] dp = new int[total][total];

        for(int len=0; len<total; len++) {
            for(int left=0; left+len<total; left++) {
                int right = left+len, count = 0;
                if(left==right){
                    count=1;
                } else if(S.charAt(left) == S.charAt(right)) {
                    count = 2 * dp[left+1][right-1];
                    int l = left + 1, r = right - 1;
                    while(l<=r && S.charAt(l) != S.charAt(left)) l++;
                    while(l<=r && S.charAt(r) != S.charAt(left)) r--;
                    if(l>r) count+= 2;
                    else if(l==r) count+=1;
                    else count-=dp[l+1][r-1];
                } else {
                    count = dp[left][right-1] + dp[left+1][right] - dp[left+1][right-1];
                }
                dp[left][right] = (count<0 ? count+1000000007 : count) % 1000000007;
            }
        }

        return dp[0][total-1];
    }

    /* Recursion with memorization
    public static int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] memory = new int[len][len];
        return recursion(S, memory, 0, len-1);
    }

    private static int recursion(String s, int[][] memory, int left, int right) {
        if(left > right) return 0;
        else if(left==right) return 1;

        if(memory[left][right] > 0) return memory[left][right];

        int count = 0;
        if(s.charAt(left) == s.charAt(right)) {
            count = 2 * recursion(s, memory, left+1, right-1);
            int l = left+1, r = right-1;
            while(l<=r && s.charAt(l) != s.charAt(left)) l++;
            while(l<=r && s.charAt(r) != s.charAt(left)) r--;
            if(l>r) count += 2;
            else if(l==r) count +=1;
            else count -= recursion(s, memory, l+1, r-1);
        } else {
            count = recursion(s, memory, left, right-1) + recursion(s, memory, left+1, right) - recursion(s, memory, left+1, right-1);
        }

        count = (count<0?count+1000000007:count) % 1000000007;
        memory[left][right] = count;

        return memory[left][right];
    }
    */

}
