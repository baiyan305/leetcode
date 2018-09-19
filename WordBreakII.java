// 140. Word Break II

import java.util.*;

public class WordBreakII {
    public void run() {
        String[] wordDict = {"apple","pen","applepen","pine","pineapple"};
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList(wordDict)));
        //String[] wordDict = {"leet","code","leetcode","yan"};
        //System.out.println(wordBreak("leetcodeyan", Arrays.asList(wordDict)));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        recursion(s, 0, new HashSet<>(wordDict), map);
        return map.get(0);
    }


    private void recursion(String s, int start, Set<String> dict, HashMap<Integer, List<String>> map) {
        if(map.containsKey(start)) return;

        List<String> list = new ArrayList<>();
        map.put(start, list);

        if(start == s.length()) {
            list.add("");
            return;
        }

        int len = s.length();
        for(int end = start+1; end <= s.length(); end++) {
            String str = s.substring(start, end);
            if(dict.contains(str)) {
                recursion(s, end, dict, map);
                List<String> right = map.get(end);
                for(String r : right) list.add(str + (end == len ? "" : " ") + r);
            }
        }
    }
}