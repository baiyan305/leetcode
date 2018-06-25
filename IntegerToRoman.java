// 12. Integer to Roman

public class IntegerToRoman {
	
	public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }

    public static String intToRoman(int num) {
        String[][] digits = {
                {"I", "V", "X"},
                {"X", "L", "C"},
                {"C", "D", "M"},
                {"M", "M", "M"}
        };

        StringBuilder builder = new StringBuilder();
        int digit = 0;
        while(num > 0) {
            int digitNum = num % 10;

            if(digitNum >=1 && digitNum<=3) for(int i=0; i<digitNum; i++) builder.insert(0, digits[digit][0]);
            else if(digitNum == 4) builder.insert(0, digits[digit][0] + digits[digit][1]);
            else if(digitNum == 5) builder.insert(0, digits[digit][1]);
            else if(digitNum >= 6 && digitNum<=8 ) {
                for(int i=0; i<digitNum-5; i++) builder.insert(0, digits[digit][0]);
                builder.insert(0, digits[digit][1]);
            }else if(digitNum == 9) builder.insert(0, digits[digit][0] + digits[digit][2]);

            digit++;
            num /= 10;
        }

        return builder.toString();
    }
	
}