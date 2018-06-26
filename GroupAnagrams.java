// 49. Group Anagrams

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String code = encode(str);
            if(!map.containsKey(code)) map.put(code, new ArrayList<>());
            map.get(code).add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        for(List<String> list : map.values()) lists.add(list);

        return lists;
    }

    private static String encode(String str) {
        int[] count = new int[26];
        for(int i=0; i<str.length(); i++) count[str.charAt(i)-'a']++;
        StringBuilder builder = new StringBuilder();
        for(int i : count) builder.append(i);

        return builder.toString();
    }

}