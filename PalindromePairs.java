// 336. Palindrome Pairs

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0,0));

        String[] words1 = {"bat", "tab", "cat"};
        System.out.println(palindromePairs(words1));

        String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words2));

        String[] words3 = {"abba", ""};
        System.out.println(palindromePairs(words3));

        String[] words4 = {"ab", "ba"};
        System.out.println(palindromePairs(words4));

    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);

        for(int i=0; i<words.length; i++) {
            String word = words[i];

            for(int divide=0; divide<word.length(); divide++) {
                String leftStr = word.substring(0, divide), rightStr = word.substring(divide, word.length());
                if(isPalindrome(leftStr)) {
                    String reverseRight = reverse(rightStr);
                    if(map.containsKey(reverseRight) && map.get(reverseRight) != i) {
                        lists.add(Arrays.asList(map.get(reverseRight), i));
                    }
                }
                if(isPalindrome(rightStr)) {
                    String reverseLeft = reverse(leftStr);
                    if(map.containsKey(reverseLeft) && map.get(reverseLeft) != i) {
                        lists.add(Arrays.asList(i, map.get(reverseLeft)));
                        if(leftStr.equals("")) lists.add(Arrays.asList(map.get(reverseLeft), i));
                    }
                }
            }
        }

        return lists;
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;
        while(left < right) if(str.charAt(left++) != str.charAt(right--)) return false;
        return true;
    }

    private static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i=str.length()-1; i > -1; i--) builder.append(str.charAt(i));
        return builder.toString();
    }
	
}