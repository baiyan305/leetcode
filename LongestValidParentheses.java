// 32. Longest Valid Parentheses

import java.util.Stack;

class LongestValidParentheses {

    public static void main(String[] args){
        System.out.println(longestValidParentheses(")())()())()"));
    }
    
    public static int longestValidParentheses(String s) { 
        if(s==null) return 0;

        int max = 0, start = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.empty()) {
                    start = i + 1;
                }else{
                    stack.pop();
                    max = stack.empty() ? Math.max(max, i-start+1) : Math.max(max, i-stack.peek());
                }
            }
        }

        return max;
    }

    /* DP
    public static int longestValidParentheses(String s) { 
        if(s==null || s.length()<2) return 0;
        
        int len = s.length(), max = 0;
        int[] dp = new int[len];
    
        for(int i=1; i<len; i++) {
            if(s.charAt(i)==')') {
                if(s.charAt(i-1)=='(') {
                    dp[i] = i-2>=0 ? dp[i-2]+2 : 2;
                    max = Math.max(max, dp[i]);
                }else{
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = dp[i-1] + 2 + ( (i-dp[i-1]-2 >=0) ? dp[i-dp[i-1]-2] : 0 );
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }

        return max;
    } // end of longestValidParentheses
    */

    /* brute force
    public static int longestValidParentheses(String s) {
        if(s==null || s.length()<2) return 0;

        int max = 0;

        for(int left=0; left<s.length(); left++) {
            int countOfLeft = 0, len = 0;
            for(int right=left; right<s.length(); right++) {
                if(s.charAt(right) == '(') {
                    countOfLeft++;    
                } else if(countOfLeft>0) {
                    len += 2;
                    countOfLeft--;
                    if(countOfLeft == 0) max = Math.max(max, len);
                } else {
                    break;
                }
            } // end of inner loop
        } // end of out loop

        return max;
    } // end of longestValidParentheses
    */
}
