// 8. String to Integer (atoi)

public class StringToInteger {
	
	public static void main(String[] args) {
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("-+2"));
        System.out.println(myAtoi("9223372036854775808"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        int idx = 0, sign = 1;

        // skip leading white space
        while(idx < str.length() && str.charAt(idx) == ' ' ) idx++;
        if(idx == str.length()) return 0;

        // get sign
        if(str.charAt(idx) == '+' || str.charAt(idx) == '-') sign = str.charAt(idx++) == '-' ? -1 : 1;
        if(idx == str.length()) return 0;

        long number = 0;
        while(idx < str.length() && (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') ) {
            number = number * 10 + sign * (str.charAt(idx) - '0');
            if(number > Integer.MAX_VALUE){
                number = Integer.MAX_VALUE;
                break;
            } else if(number < Integer.MIN_VALUE) {
                number = Integer.MIN_VALUE;
                break;
            }
            
            idx++;
        }
        
        return (int) number;
    }
	
}