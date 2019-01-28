// 340. Longest Substring with At Most K Distinct Characters

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public void run() {
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println("123");
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;

        for(int left=0, right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);

            while(map.size() > k && left<=right) {
                char cLeft = s.charAt(left);
                int appear = map.get(cLeft);
                if(appear == 1) map.remove(cLeft);
                else map.put(cLeft, appear-1);

                left++;
            }

            res = Math.max(res, right-left+1);
        }

        return res;
    }

}
