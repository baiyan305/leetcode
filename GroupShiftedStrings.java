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
            int offset = 26 - (str.charAt(0) - 'a');
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<str.length(); i++) {
                int c = str.charAt(i) + offset;
                if(c > 'z') c -= 26;
                builder.append(c);
            }

            String key = builder.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        for(List<String> list : map.values()) {
            lists.add(list);
        }

        return lists;
    }

}