// 38. Count and Say

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String str = "1";

        for(int i=1; i<n; i++) {
            StringBuilder builder = new StringBuilder();
            char cur = str.charAt(0);
            int count = 1;
            for(int j=1; j<=str.length(); j++) {
                if(j == str.length() || str.charAt(j) != cur) {
                    builder.append(count);
                    builder.append(cur);
                    if(j != str.length()) cur = str.charAt(j);
                    count=1;
                } else {
                    count++;
                }
            }

            str = builder.toString();
        }

        return str;
    }

}