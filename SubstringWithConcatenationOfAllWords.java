// 30. Substring with Concatenation of All Words

public class SubstringWithConcatenationOfAllWords {
	
	public static void main(String[] args) {
        //String s = "barfoothefoobarfooman";
        //String s = "barfoothefoobarfooman";
        //String[] words = {"foo","bar"};

        String s = "aaaaaaa";
        String[] words = {"aa","aa","aa"};

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length == 0) return list;

        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) map.put(word, 0);
            map.put(word, map.get(word)+1);
        }

        int window = words[0].length() * words.length, wordLen = words[0].length();
        for(int right = window; right<=s.length(); right++) {
            HashMap<String, Integer> seen = new HashMap<>();
            for(int left = right-window; left <= right; left += wordLen) {
                if(left == right) {
                    list.add(right-window);
                } else {
                    String newWord = s.substring(left, left+wordLen);
                    if(!seen.containsKey(newWord)) seen.put(newWord, 0);
                    seen.put(newWord, seen.get(newWord)+1);
                    if(seen.get(newWord) > map.getOrDefault(newWord, 0)) break;
                }
            }
        }

        return list;
    }
	
}