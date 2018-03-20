// 3. Longest Substring Without Repeating Characters

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    } // end of main

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int i = 0, j = 1, len = s.length(), longest = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();        
        map.put(s.charAt(i), i);

        while(j < len) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                // Remove characters from map
                int newi = map.get(c);
                for(int x=i; x<newi; x++){
                    map.remove(s.charAt(x));
                }

                // update length
                longest = Math.max(longest, j-i);

                // update i
                i = newi + 1;

                // add s[j] to map
                map.put(s.charAt(j), j);

                j++;
            } else {
                map.put(s.charAt(j), j);
                j++;
            }        
        } // end of while        
   
        longest = Math.max(longest, j-i);
        return longest; 
    } //end of lengthOfLongestSubstring

}
