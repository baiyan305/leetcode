// 394. Decode String

import java.util.Stack;

public class DecodeString {

    public void run() {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    // 非递归
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int len = s.length();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int count = 0;
                while(i<len && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(count);
            }else if(c == '[') {
                strStack.push(builder.toString());
                builder.setLength(0);
            }else if(c == ']') {
                String pattern = builder.toString();
                int repeat = numStack.pop();
                builder = new StringBuilder(strStack.pop());
                while(repeat-->0) builder.append(pattern);
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    /* 递归
    public String decodeString(String s) {
        return recursion(s, new int[1]);
    }

    private String recursion(String s, int[] idx) {
        int len = s.length(), num = 0;

        StringBuilder builder = new StringBuilder();
        for(; idx[0]<len; idx[0]++) {
            char c = s.charAt(idx[0]);
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if(c == '[') {
                idx[0]++;
                String pattern = recursion(s, idx);
                for(; num>0; num--) builder.append(pattern);
            } else if(c == ']') {
                return builder.toString();
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
    */
	
}