// 233. Number of Digit One

public class NumberOfDigitOne {

    public void run() {
        System.out.println(countDigitOne(1410065408));
    }

    public int countDigitOne(int n) {
        int total = 0, base = 1, i = n;

        while(i>0) {
            int digit = i % 10, high = i / 10, low = n % base;
            total += high * base;
            if(digit == 1) total += (low + 1);
            else if(digit > 1) total += base;

            base *= 10;
            i/=10;
        }

        return total;
    }

}
