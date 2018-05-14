// 392. Is Subsequence

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {
	
	public static void main(String[] args) {
		System.out.println(isSubsequence("abc","ahbgdc"));
		System.out.println(isSubsequence("axc","ahbgdc"));
	}
	
	public static boolean isSubsequence(String s, String t) {
		if(s==null || t==null) return false;
		
		HashMap<Character, List<Integer>> map = new HashMap<>();
		for(int i=0; i<t.length(); i++) {
			char c = t.charAt(i);
			if(!map.containsKey(c)) map.put(c, new ArrayList<>());
			map.get(c).add(i);
		}
		
		int prev = -1;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(!map.containsKey(c)) return false;
			prev = binarySearch( map.get(s.charAt(i)), prev);
			if(prev == -1) return false;
			prev++;
		}
		
		return true;
	}
	
	private static int binarySearch(List<Integer> list, int idx) {
		int left = 0, right = list.size()-1;
		while(left<=right) {
			int mid = left + (right-left)/2;
			if(list.get(mid) >= idx) right = mid-1;
			else left = mid+1;
		}
		
		return left == list.size() ? -1 : list.get(left);
	}
	
	
	/*
	public static boolean isSubsequence(String s, String t) {
		if(s==null || t==null) return false;
		
        int lenS = s.length(), lenT = t.length();
		int idxS = 0, idxT = 0;
		
		while(idxS<lenS && idxT<lenT) {
			if(s.charAt(idxS) == t.charAt(idxT)) idxS++;
			idxT++;
		}
		
		return idxS == lenS;
    }
	*/
	
}