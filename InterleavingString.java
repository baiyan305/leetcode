// 97. Interleaving String

public class InterleavingString {
	
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("db", "b", "cbb"));
	}
	
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
		
		int len1 = s1.length(), len2 = s2.length();
		boolean[][] dp = new boolean[len1+1][len2 +1];
		dp[0][0] = true;
		
		for(int i=1; i<len1+1; i++)
			dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0] ? true : false;

		for(int i=1; i<len2+1; i++)
			dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1] ? true : false;
		
		for(int i=1; i<=len1; i++)
			for(int j=1; j<=len2; j++)
				if( (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) ) dp[i][j] = true;
		
		return dp[len1][len2];
    }
	
	
	/* Recursion
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
		
		return isInterleave(s1,s2,s3,0,0,0);
    }
	
	private static boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3) {
		if(i3 == s3.length()) return true;
		
		if( i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1) && i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
			return isInterleave(s1,s2,s3,i1+1,i2,i3+1) || isInterleave(s1,s2,s3,i1,i2+1,i3+1);
		} else if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
			return isInterleave(s1,s2,s3,i1+1,i2,i3+1);
		} else if (i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
			return isInterleave(s1,s2,s3,i1,i2+1,i3+1);
		} else {
			return false;
		}
	}
	*/		
}