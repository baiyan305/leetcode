// 273. Integer to English Words

public class IntegerToEnglishWords {

    public static void main(String[] args) {
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(100));
        System.out.println(numberToWords(110));
        System.out.println(numberToWords(19));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(12345));
    }


    public static String numberToWords(int num) {
        String[] str1 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] str2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] metrics = {"", "Thousand", "Million", "Billion"};

        int[] nums = new int[]{num % 1000, (num / 1000) % 1000, (num / (1000 * 1000)) % 1000, num / (1000 * 1000 * 1000)};

        StringBuilder builder = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--) {
            int n = nums[i];
            if(n == 0) continue;

            // 百位
            if(n/100 != 0) builder.append(" ").append(str1[n/100-1]).append(" ").append("Hundred");
            n %= 100;

            // 十位
            if(n<20 && n>0) {
                builder.append(" ").append(str1[n-1]);
                n = 0;
            } else if(n/10%10 != 0) {
                builder.append(" ").append(str2[n/10%10 -2]);
                n %= 10;
            }

            // 个位
            if(n%10 != 0) builder.append(" ").append(str1[n%10 -1]);

            if(i != 0)builder.append(" ").append(metrics[i]);
        }

        return builder.length() == 0 ? "Zero" : builder.substring(1);
    }

}