// 5. Longest Palindromic Substring

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbaaaaba"));
    }

	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0) return s;

        int len = s.length(), maxLeft = 0, maxRight = 0;
        boolean[][] dp = new boolean[len][len];
		
		for(int out=0; out<len; out++) {
			for(int in=0; in<=out; in++) {
				dp[in][out] = s.charAt(in) == s.charAt(out) && (out-in < 3 || dp[in+1][out-1]);
				if(dp[in][out] && out-in>maxRight-maxLeft){
					maxLeft = in;
					maxRight = out;
				}
			}
		}
		
		return s.substring(maxLeft, maxRight+1);
	}
	
	
	
	
	
	
	
	
	
	/*
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;

        int len = s.length(), maxLeft = 0, maxRight = 0;
        boolean[][] dp = new boolean[len][len];

        for(int span=1; span<=len; span++) {
            for(int i=0; i<len-span+1; i++) {
                if( s.charAt(i) == s.charAt(i+span-1) && (span<4 || dp[i+1][i+span-2]) ) {
                    dp[i][i+span-1] = true;
                    if(span > maxRight - maxLeft){
                        maxLeft = i;
                        maxRight = i + span;
                    }
                }
            }
        }

        return s.substring(maxLeft, maxRight);
    }
	*/
    /*
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int[] longest = new int[]{0, 0};

        for(int i=0; i<s.length(); i++) {
            int[] odd = helper(s, i, i);
            int[] even = helper(s, i, i+1);
            int[] tmp = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = tmp[1] - tmp[0] > longest[1] - longest[0] ? tmp : longest; 
        }

        return s.substring(longest[0]+1, longest[1]);
    }

    private static int[] helper(String s, int left, int right){
        int len = s.length();
        int[] ret = new int[]{0, 0};

        while(left >=0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        ret[0] = left;
        ret[1] = right;

        return ret; 
    }
    */ 
}

