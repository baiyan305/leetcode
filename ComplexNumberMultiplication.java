// 537. Complex Number Multiplication

public class ComplexNumberMultiplication{

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i","1+-1i"));
        System.out.println(complexNumberMultiply("10+-1i","10+-1i"));
    }

    public static String complexNumberMultiply(String a, String b) {
        String[] strs1 = a.substring(0, a.length()-1).split("\\+");
        int num1 = Integer.parseInt(strs1[0]);
        int i1 = Integer.parseInt(strs1[1]);
        String[] strs2 = b.substring(0, b.length()-1).split("\\+");
        int num2 = Integer.parseInt(strs2[0]);
        int i2 = Integer.parseInt(strs2[1]);

        return String.valueOf(num1 * num2 - i1 * i2) + "+" + String.valueOf(num1*i2 + num2*i1) + "i";
    }

}
