// 249. Group Shifted Strings

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(strings));
    }


    public static List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strings) {
            StringBuilder key = new StringBuilder();
            for(int i=1; i<str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i-1);
                if(diff <0) diff += 26;
                key.append(diff+'.');
            }

            String keystr = key.toString();
            if(!map.containsKey(keystr)) map.put(keystr, new ArrayList<>());
            map.get(keystr).add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        for(List<String> list : map.values()) {
            lists.add(list);
        }

        return lists;
    }

}