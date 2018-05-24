// 44. Wildcard Matching

public class WildcardMatching {
	
	public static void main(String[] args) {
		System.out.println(isMatch("",""));
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("cb","?a"));
		System.out.println(isMatch("adceb","*a*b"));
		System.out.println(isMatch("acdcb","a*c?b"));
	}
	
	public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
		dp[0][0] = true;
		
		for(int ip=1; ip<=p.length(); ip++){
			dp[ip][0] = p.charAt(ip-1) == '*' ? dp[ip-1][0] : false;
		}
		
		for(int ip=1; ip<=p.length(); ip++) {
			char pattern = p.charAt(ip-1);
			for(int is=1; is<=s.length(); is++) {
				if(pattern == '*') {
					dp[ip][is] = dp[ip-1][is] || dp[ip][is-1];
				} else if(pattern == '?' || pattern == s.charAt(is-1)) {
					dp[ip][is] = dp[ip-1][is-1];
				}
			}
		}
		
		return dp[p.length()][s.length()];
    }
	
}