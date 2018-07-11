// 166. Fraction to Recurring Decimal

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public void run() {
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(10, 2));
        System.out.println(fractionToDecimal(1, 7));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(1, -6));
        System.out.println(fractionToDecimal(-2147483648, 1));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();

        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) builder.append('-');

        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
        builder.append(num/den);
        num %= den;

        if(num == 0) return builder.toString();

        builder.append('.');
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, builder.length());
        while(num != 0) {
            num *= 10;
            builder.append(num/den);
            num %= den;
            if(map.containsKey(num)) {
                builder.insert((int)(map.get(num)), '(').append(')');
                break;
            }

            map.put(num, builder.length());
        }

        return builder.toString();
    }

}