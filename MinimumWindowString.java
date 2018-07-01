// 76. Minimum Window Substring

public class MinimumWindowString {
	
	public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if(count == null) map.put(ch, 1);
            else map.put(ch, count+1);
        }
        int map_size = map.size();

        int slow = 0, match_count = 0, min = -1, min_left = 0;
        for(int fast = 0; fast<s.length(); fast++) {
            char ch_fast = s.charAt(fast);
            Integer count = map.get(ch_fast);
            if(count != null) {
                map.put(ch_fast, --count);
                if(count == 0) match_count++;
            }

            while(match_count == map_size) {
                if(min == -1 || fast-slow+1 < min) {
                    min = fast-slow+1;
                    min_left = slow;
                }

                char char_slow = s.charAt(slow++);
                Integer count_slow = map.get(char_slow);
                if(count_slow != null) {
                    map.put(char_slow, ++count_slow);
                    if(count_slow == 1) match_count--;
                }
            }
        }

        return min == -1 ? "" : s.substring(min_left, min_left+min);
    }
	
}