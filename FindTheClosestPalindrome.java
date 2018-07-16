// 564. Find the Closest Palindrome

import java.util.Arrays;

public class FindTheClosestPalindrome {
    public void run() {
        System.out.println(nearestPalindromic("123"));
        //System.out.println(nearestPalindromic("1"));
        //System.out.println(nearestPalindromic("9"));
    }



    public String nearestPalindromic(String n) {
        if(n == null || n.length() == 0) return n;

        char[] chars = n.toCharArray();
        int left = 0, right = n.length()-1;
        while(right-left>1) chars[right--] = chars[left++];
        chars[right] = chars[left];

        String[] candidates = new String[5];
        Arrays.fill(candidates, "");
        for(int i=-1; i<2; i++) {
            char oriVal = chars[left], newVal = (char)(chars[left] + i);
            if(newVal>='0' && newVal<='9') {
                chars[left] = chars[right] = newVal;
                candidates[i+1] = new String(chars);
                chars[left] = chars[right] = oriVal;
            }
        }

        StringBuilder builder = new StringBuilder(n.length()-1);
        for(int i=0; i<n.length()-1; i++) builder.append('9');
        candidates[3] = builder.toString();

        builder = new StringBuilder(n.length()+1);
        for(int i=0; i<=n.length(); i++) builder.append( (i==0||i==n.length()) ? '1' : '0');
        candidates[4] = builder.toString();

        long base = Long.parseLong(n), minDiff = Long.MAX_VALUE;
        int minIdx = 0;
        for(int i=0; i<5; i++) {
            if(candidates[i].equals("") || candidates[i].equals(n)) continue;

            long palindrome = Long.parseLong(candidates[i]);
            long diff = Math.abs(palindrome-base);
            if(diff < minDiff || (diff == minDiff && palindrome < Long.parseLong(candidates[minIdx]))) {
                minDiff = diff;
                minIdx = i;
            }
        }

        return candidates[minIdx];
    }

}
