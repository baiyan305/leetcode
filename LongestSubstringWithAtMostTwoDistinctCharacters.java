// 159. Longest Substring with At Most Two Distinct Characters

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithAtMostTwoDistinctCharacters{

    public static void main(String[] args){
       System.out.println(lengthOfLongestSubstringTwoDistinct("ecebabaaaafffffffffff"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;

        int left = 0, right = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right<s.length()) {
            if(map.size()<=2) {
                map.put(s.charAt(right), right);
                right++;
            }
            if(map.size()>2) {
                int leftMost = s.length();
                for(int val : map.values()){
                    leftMost = Math.min(leftMost, val);
                }
                map.remove(s.charAt(leftMost));
                left = leftMost + 1;
            }

            longest = Math.max(longest, right - left);
        }

        return longest;
    }

    /*
    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) return 0;
        if(s.length() < 3) return s.length();

        int l=0, r=0, longest=0, len = s.length();
        Set<Character> set = new HashSet<Character>();        

        while(r < len) {
            if(!set.contains(s.charAt(r))){
                if(set.size() < 2){
                    set.add(s.charAt(r));
                }else{
                    longest = Math.max(longest, r-l);
                    int k = r-1;
                    while(k>=l && s.charAt(k) == s.charAt(k-1)){
                        k--;
                    }
                    l = k; 

                    set.clear();
                    set.add(s.charAt(l));
                    set.add(s.charAt(r));
                }
            }

            r++;             
        }        
        
        // need to calculate longest once again
        longest = Math.max(longest, r-l);

        return longest;
    } //end of lengthOfLongestSubstringTwoDistinct
    */
}
