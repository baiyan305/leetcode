// 132. Palindrome Partitioning II

import java.util.List;
import java.util.ArrayList;

class PalindromePartitioningII {
	
	public static void main(String[] args) {
        System.out.println(minCut(""));
	}
    
    public static int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
           
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cuts = new int[len];

        for(int i=0; i<len; i++) {
            cuts[i] = i;
        }

        for(int right=0; right<len; right++) {
            for(int left=0; left<=right; left++) {
                if( s.charAt(left) == s.charAt(right) && (right-left<3||dp[left+1][right-1]) ){
                    dp[left][right] = true;
                    cuts[right] = left == 0 ? 0 : Math.min(cuts[right], cuts[left-1]+1);
                }
            }
        }

        return cuts[len-1];
    }	
	
}
