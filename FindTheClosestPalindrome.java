// 564. Find the Closest Palindrome

import java.util.Arrays;

public class FindTheClosestPalindrome {
    public void run() {
        System.out.println(nearestPalindromic("123"));
        //System.out.println(nearestPalindromic("1"));
        //System.out.println(nearestPalindromic("9"));
    }

    // 寻找最近的palindrome
    // 首先看输入的字符串。如果不是Palindrome:
    // 1.翻转前半部分后覆盖后半部分。
    // 2.翻转后半部分后覆盖前半部分。
    // 显然第一种方法得到的结果比2更接近原字符串，因为变换的是低位。

    // 在翻转左半边，覆盖右半边后，得到的字符串有可能是最终结果，也可能不是。
    // 比如 12399, 翻转后得到 12321, 其实最近的回文是12421，就是将中间的3加1
    // 比如 99301, 翻转后得到 99399, 其实最近的回文是99299，就是将中间的3减1
    // 比如 12320, 翻转后得到 12321，就是最近的回文，中间的3加0
    //
    // 所以有3中翻转方式。先取左边部分，然后+0，+1，-1，之后覆盖右半部分。就得到了3个candidates。
    //
    // Edge case:
    // 对于3位数字XXX，可能1001，或者99是答案
    //
    // 所以一共有5个candidates。
    public String nearestPalindromic(String n) {
        if(n==null || n.length()==0) return n;
        int len = n.length();

        List<Long> list = new ArrayList<>();

        // 得到两个极限值，比如999，1001这种
        list.add((long)(Math.pow(10,len)+1));
        list.add((long)(Math.pow(10,len-1)-1));

        // 取左半边。长度为奇数的话，中间的数字，包含在左边。
        long leftLong = Long.parseLong(n.substring(0, len/2+len%2));
        for(int i=-1; i<=1; i++) {
            String left = String.valueOf(leftLong+i);
            String right = new StringBuilder(left).reverse().toString();
            //左半边长度是奇数的话，要减去一个
            if(right.length()>1 && right.length()%2 != 0) right = right.substring(1);
            String palindrome = left + right;
            if(!palindrome.equals(n)) //新的字符串，不能和原来的一样
                list.add(Long.parseLong(palindrome));
        }

        long base = Long.parseLong(n);
        int nearest = 0;
        for(int i=1; i<list.size(); i++) {
            long diffMin = Math.abs(list.get(nearest) - base);
            long diff = Math.abs(list.get(i) - base);
            if(diff < diffMin) nearest = i;
            else if(diff == diffMin && list.get(i) < list.get(nearest))
                nearest = i;
        }

        return String.valueOf(list.get(nearest));
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
