// 288. Unique Word Abbreviation

import java.util.*;

public class UniqueWordAbbreviation {

    public void run() {
        String[] dictionary = {"deer", "door", "cake", "card"};
        ValidWordAbbr valid = new ValidWordAbbr(dictionary);
        System.out.println(valid.isUnique("dear"));
        System.out.println(valid.isUnique("cart"));
        System.out.println(valid.isUnique("cane"));
        System.out.println(valid.isUnique("make"));
    }

    class ValidWordAbbr {
        HashMap<String, String> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for(String str : dictionary) {
                String abbre = abbreviation(str);
                if(!map.containsKey(abbre)) {
                    map.put(abbre, str);
                } else if(!map.get(abbre).equals(str)) {
                    map.put(abbre, " ");
                }
            }
        }

        public boolean isUnique(String word) {
            String abbre = abbreviation(word);
            return !map.containsKey(abbre) || map.containsKey(abbre)&&map.get(abbre).equals(word);
        }

        private String abbreviation(String str) {
            if(str.length() <= 2) return str;
            return str.charAt(0) + String.valueOf(str.length()-2) +str.charAt(str.length()-1);
        }
    }
}
