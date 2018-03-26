// 131. Palindrome Partitioning

import java.util.List;
import java.util.ArrayList;

class PalindromePartitioning {
	
	public static void main(String[] args) {
		List<List<String>> res = partition("abcd");
		
		for(List<String> list: res) {
			for(String str : list) {
				System.out.println(str+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s == null) return res;
		
        int len = s.length();
		boolean[][] dp = new boolean[len][len];
		
		backtracking(s, 0, new ArrayList<>(), res, dp);
		
		return res;
    }
	
	private static void backtracking(String s, int start, List<String> list, List<List<String>> res, boolean[][] dp) {
		if(start >= s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for(int i=start; i<s.length(); i++) {
			if(s.charAt(start) == s.charAt(i) && (i-start<3 || dp[start+1][i-1])) {
				dp[start][i] = true;
				list.add(s.substring(start, i+1));
				backtracking(s, i+1, list, res, dp);
				list.remove(list.size()-1);
			}
		}
	}
	
	
	
}