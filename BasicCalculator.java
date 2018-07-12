// 224. Basic Calculator

import java.util.Stack;

public class BasicCalculator {

    public void run() {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("( 10 +(4  + 5+ 2 ) -3)+(6+8)"));
        System.out.println(calculate("1+2"));
        System.out.println(calculate("--1"));
    }

    // Stack当中只存加减号，每找到一个数字就马上将这个数字累加到结果中。
    // 至于加减号的计算，相当于一层一层的看加减号对里面一层的影响。
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        int num = 0, sign = 1, sum = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if(ch == '+' || ch =='-') {
                sum += sign * num;
                sign = stack.peek() * (ch == '+' ? 1 : -1);
                num = 0;
            } else if(ch == '(') {
                stack.push(sign);
            } else if(ch == ')'){
                sum += sign * num;
                num = 0;
                sign = 1;
                stack.pop();
            }
        }

        sum += sign * num;
        return sum;
    }

    /*
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            if(ch == ' ') continue;

            if(ch == '-' || ch == '+') {
                if(builder.length() != 0) {
                    stack.push(builder.reverse().toString());
                    builder.setLength(0);
                }
                if(ch == '-') stack.push(String.valueOf(-1 * Integer.valueOf(stack.pop())));
            } else if(ch >= '0' && ch<='9') {
                builder.append(ch);
            } else if(ch == ')') {
                stack.push(String.valueOf(ch));
            } else if(ch == '(') {
                if(builder.length() != 0) {
                    stack.push(builder.reverse().toString());
                    builder.setLength(0);
                }
                int sum = 0;
                while(!stack.peek().equals(")")) sum += Integer.valueOf(stack.pop());
                stack.pop();
                stack.push(String.valueOf(sum));
            }
        }

        if(builder.length() != 0) stack.push(builder.reverse().toString());

        int sum = 0;
        while(!stack.isEmpty()) sum += Integer.valueOf(stack.pop());

        return sum;
    }
    */

}