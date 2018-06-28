// 43. Multiply Strings

public class MultiplyStrings {
	
	public static void main(String[] args) {
        //System.out.println(multiply("999999","1111"));
        System.out.println(multiply("2","3"));
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] arr = new int[len1+len2];

        for(int i=len1-1; i>=0; i--){
            for(int j=len2-1; j>=0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i+j+1] += product%10;
                arr[i+j] += product/10;
            }
        }

        int carry = 0;
        for(int i=arr.length-1; i>=0; i--) {
            int sum = arr[i] + carry;
            arr[i] =sum % 10;
            carry = sum / 10;
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            if(!(arr[i] == 0 && builder.length() == 0)) builder.append(arr[i]);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
	
}