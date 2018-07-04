// 556. Next Greater Element III

import java.util.Arrays;

public class NextGreaterElementIII{

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(2147483647));
        System.out.println(nextGreaterElement(230241));
        System.out.println(nextGreaterElement(12443322));
    }

    public static int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        int i = chars.length-1, j = i;
        while(i>0 && chars[i-1] >= chars[i]) i--;
        if(i-- == 0) return -1;

        while(chars[i] >= chars[j]) j--;
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;

        Arrays.sort(chars, i+1, chars.length);
        long value = Long.valueOf(new String(chars));

        return value > Integer.MAX_VALUE ? -1 : (int)value;
    }

}