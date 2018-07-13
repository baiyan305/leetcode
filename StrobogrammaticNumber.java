// 246. Strobogrammatic Number

public class StrobogrammaticNumber {

    public void run() {
        System.out.println(isStrobogrammatic("69"));
        System.out.println(isStrobogrammatic("88"));
        System.out.println(isStrobogrammatic("962"));
        System.out.println(isStrobogrammatic("1"));
    }

    public boolean isStrobogrammatic(String num) {
        int[] pairs = new int[10];
        pairs[1] = 1;
        pairs[6] = 9;
        pairs[8] = 8;
        pairs[9] = 6;

        int left = 0, right = num.length()-1;
        while(left<=right) {
            int numLeft = num.charAt(left++) - '0';
            int numRight = num.charAt(right--) - '0';
            if(pairs[numLeft] != numRight) return false;
        }

        return true;
    }

}