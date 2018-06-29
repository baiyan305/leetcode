// 151. Reverse Words in a String

public class ReverseWordsInString {
	
	public static void main(String[] args) {
        System.out.println(reverseWords("23 ab c"));
        System.out.println(reverseWords(" 23    ab    c   "));
        System.out.println(reverseWords("  c   "));
        System.out.println(reverseWords("c"));
        System.out.println(reverseWords(" "));
        System.out.println(reverseWords(""));
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();

        reverse(chars, 0, chars.length-1);
        reverseWord(chars);
        return deleteSpace(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while(left<right){
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    private static void reverseWord(char[] chars) {
        int left = 0, right = 0;
        while(left < chars.length) {
            while(left < chars.length && chars[left] == ' ') left++;
            right=left;
            while(right < chars.length && chars[right] != ' ') right++;
            reverse(chars, left, right-1);
            left = right;
        }
    }

    private static String deleteSpace(char[] chars) {
        int pos = 0;
        for(int i=0; i<chars.length; i++) {
            if(chars[i] != ' ') chars[pos++] = chars[i];
            else if(i-1>=0 && chars[i-1] != ' ') chars[pos++] = ' ';
        }
        if(pos-1>=0 && chars[pos-1] == ' ') pos--;

        return new String(chars).substring(0, pos);
    }

	
}