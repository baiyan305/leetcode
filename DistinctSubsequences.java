// 115. Distinct Subsequences

public class DistinctSubsequences {
	
	public static void main(String[] args) {
        //System.out.println(numDistinct("rabbbit","rabbit"));
		System.out.println(numDistinct("banana","ban"));
    }
	
	public static int numDistinct(String s, String t) {
        if(s==null || t==null) return 0;
		
		int len1 = s.length(), len2 = t.length();
		int[][] dp = new int[len1][len2];
		
		int count = 0;
		for(int i=0; i<len1; i++) {
			if(s.charAt(i) == t.charAt(0)){
				count++;
			}
			dp[i][0] = count;
		}
		
		for(int i=1; i<len2; i++) {
			for(int j=1; j<len1; j++) {
				if(s.charAt(j) == t.charAt(i))
					dp[j][i] = dp[j-1][i-1] + dp[j-1][i];
				else
					dp[j][i] = dp[j-1][i];
			}
		}
		
		return dp[len1-1][len2-1];
    }
	
	public static int helper(String s, String t, int i, int j) {
		if(j==-1) return 1;
		if(i==-1) return 0;
		
		if(s.charAt(i) != t.charAt(j)) {
			return helper(s, t, i-1, j);
		} else{
			return helper(s, t, i-1, j-1) + helper(s, t, i-1, j);
		}
	}
	
}