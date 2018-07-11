// 9. Palindrome Number

public class PalindromeNumber {

    public void run() {
        System.out.println(isPalindrome(3210123));
        System.out.println(isPalindrome(-3210123));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
        System.out.println(isPalindrome(Integer.MIN_VALUE));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int palindrome = 0, i = x;
        while(i > 0) {
            palindrome = palindrome * 10 + i % 10;
            i /= 10;
        }

        return palindrome == x;
    }

}