// 214. Shortest Palindrome

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

    private String recursion(String s, int left, int right) {
        int l = left;
        for(int r=right; r>=0; r--) {
            if(s.charAt(l) == s.charAt(r)) l++;
        }
        if(l==right+1) return s.substring(left, right+1);
        String str = s.substring(l, right+1);
        return new StringBuilder().append(str).reverse().toString() + recursion(s, left, l-1) + str;
    }

}
