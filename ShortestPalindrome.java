// 214. Shortest Palindrome

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        return recursion(s, s.length()-1);
    }

    // 思路是找到从0开始的最长回文，这个方法比暴力解法优化一些。
    // 首先left指向0, right指向最右。right从最右循环到0，如果char left == char right, 那么left++。
    // 循环完成后，我们要找的最长回文，一定在0到left的范围内。为什么呢？
    // 举个例子：比如 abcbaxxxx 把这个字符串拆成两部分
    // 第一部分是我们要找的最长回文abcba, 第二部分是xxxx，这个xxxx可以是任何字符
    // 假如xxxx中没有a,b,c。按照逻辑, 最后left会停在e的位置，那么我们要找的最长回文一定在0到left之间
    // 假如xxxx中含有a或b或c。按照逻辑，最后left会停在更加右边，那么我们要找的最长回文还是在0到left之间
    // 最差的情况
    // abcdefgh
    private String recursion(String s, int end) {
        int left = 0;

        for(int right=end; right>=0; right--)
            if(s.charAt(right) == s.charAt(left))
                left++;

        if(left == end+1) return s.substring(0, end+1);

        String str = s.substring(left, end+1);
        return new StringBuilder(str).reverse().toString() + recursion(s, left-1) + str;
    }

}
