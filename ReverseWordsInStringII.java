// 186. Reverse Words in a String II

public class ReverseWordsInStringII {
	
	public static void main(String[] args) {
        System.out.println(reverseWords("23 ab c"));

    }
	
	public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        reverseWord(str);
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
}