// 139. Word Break

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public void run() {
        String[] strs = {"leet","codes"};
        System.out.println(wordBreak("leetcode", Arrays.asList(strs)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        return wordBreak(s, 0, set, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, int start, Set<String> dict, Boolean[] mem) {
        if(start >= s.length()) return true;
        if(mem[start] != null) return mem[start];

        for(String word : dict) {
            int len = word.length();
            if(start+len <= s.length() && s.substring(start, start+len).equals(word) && wordBreak(s, start+len, dict, mem)) {
                mem[start] = true;
                return true;
            }
        }

        mem[start] = false;
        return false;
    }

    /* 一维DP
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean[] dp = new boolean[s.length()];
        for(int end=1; end<=s.length(); end++) {
            for(int start=end-1; start>=0; start--) {
                String right = s.substring(start, end);
                if( set.contains(right) && (start==0 || dp[start-1]) ){
                    dp[end-1] = true;
                    break;
                }
            }
        }

        return dp[s.length()-1];
    }
    */

    /* DFS + Memorization
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        return wordBreak(s, 0, set, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, int start, Set<String> dict, Boolean[] mem) {
        if(start >= s.length()) return true;
        if(mem[start] != null) return mem[start];

        for(int end = start+1; end<=s.length(); end++) {
            if(dict.contains(s.substring(start, end)) && wordBreak(s, end, dict, mem)) {
                mem[start] = true;
                return true;
            }
        }

        mem[start] = false;
        return false;
    }
    */

}
