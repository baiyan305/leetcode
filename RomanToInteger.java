// 13. Roman to Integer

public class RomanToInteger {
	
	public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int num = 0;

        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if(num>=5) num -= 1;
                    else num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if(num < 50) num += 10;
                    else num -= 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C' :
                    if(num<500) num += 100;
                    else num -= 100;
                    break;
                case 'D' :
                    num += 500;
                    break;
                case 'M' :
                    num += 1000;
                    break;
            }

        }

        return num;
    }
	
}