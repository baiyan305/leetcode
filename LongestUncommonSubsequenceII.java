// 522. Longest Uncommon Subsequence II

import java.util.ArrayList;
import java.util.List;

public class LongestUncommonSubsequenceII{
    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae", "abce", "abcd"})); //4
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));  //-1
        System.out.println(findLUSlength(new String[]{"abcabc","abcabc","abcabc","abc","abc","cca"}));  //3
    }

    public static int findLUSlength(String[] strs) {
        //initialize list
        List<List<String>> lists = new ArrayList<>();
        for(int i=0; i<10; i++) lists.add(new ArrayList<String>());
        for(String str : strs) if(!str.equals("")) lists.get(str.length()-1).add(str);

        for(int i=9; i>=0; i--) {
            List<String> list = lists.get(i);
            for(String str : list) {
                if(!isDistinct(list, str)) continue;

                boolean isSub = false;
                for(int j=i+1; j<10; j++) {
                    if(isSubSequence(lists.get(j), str)){
                        isSub = true;
                        break;
                    }
                }
                if(!isSub) return str.length();
            }
        }

        return -1;
    }

    private static boolean isDistinct(List<String> list, String target) {
        int count = 0;
        for(String str : list) {
            if(str.equals(target)) count += 1;
        }

        return count == 1 ? true : false;
    }

    private static boolean isSubSequence(List<String> list, String sub) {
        for(String str : list){
            int idx = 0;
            for(char ch : str.toCharArray()) {
                if(ch == sub.charAt(idx)) idx++;
                if(idx == sub.length()) return true;
            }
        }

        return false;
    }
}