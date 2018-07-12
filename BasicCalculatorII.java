// 227. Basic Calculator II

import java.util.Stack;

public class BasicCalculatorII {

    public void run() {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3-2*2"));
        System.out.println(calculate(" 3/2 "));
    }


    // 根据数字前面的符号来判断如何处理这个数字。
    // 如果是 '+': 将当前数字乘以Sign加到Stack顶部
    // 如果是 '-': 将当前数字乘以Sign之后加到Stack顶部
    // 如果是 '*': 将当前数字乘以栈顶数字之后加入到Stack顶部
    // 如果是 '.': 将当前数字除以栈顶数字之后加入到Stack顶部
    // 如果当前字符是 + 或者 - ,要更新sign
    public int calculate(String s) {
        //s = s + '+';
        Stack<Integer> stack = new Stack<>();

        char sign = '+';
        int num = 0;
        char[] chars = s.toCharArray();
        for(int i=0; i<=chars.length; i++) {
            char ch = i == chars.length ? '+' : chars[i];
            if(ch == ' ') continue;

            if(Character.isDigit(ch)) num = num * 10 + ch - '0';
            else {
                switch(sign) {
                    case '+':
                        stack.push(num * 1);
                        break;
                    case '-':
                        stack.push(num * -1);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                sign = ch;
                num = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();
        return sum;
    }

}