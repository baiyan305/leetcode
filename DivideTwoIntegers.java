// 29. Divide Two Integers

public class DivideTwoIntegers {

    public void run() {
        System.out.println(divide(0, 3));
        System.out.println(divide(15, 3));
        System.out.println(divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;

        long res = 0;
        long longDividend = Math.abs((long) dividend), longDivisor = Math.abs((long) divisor);
        while(longDividend >= longDivisor) {
            long longDivisorTmp = longDivisor, multiple = 1;
            while(longDividend >= (longDivisorTmp<<1)) {
                longDivisorTmp = longDivisorTmp << 1;
                multiple = multiple << 1;
            }
            longDividend -= longDivisorTmp;
            res += multiple;
        }

        res *= sign;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }

}
