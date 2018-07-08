// 791. Custom Sort String

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(customSortString("cba","abcd"));
    }

    public String customSortString(String S, String T) {
        int[] counts = new int[26];
        for(char ch : T.toCharArray()) counts[ch-'a']++;

        StringBuilder builder = new StringBuilder();
        for(char ch : S.toCharArray()) {
            int idx = ch - 'a';
            while(counts[idx]-- > 0) builder.append(ch);
        }
        for(int i=0; i<counts.length; i++) {
            if(counts[i] != 0) {
                char ch = (char)('a'+i);
                while(counts[i]-- > 0) builder.append(ch);
            }
        }

        return builder.toString();
    }

}
