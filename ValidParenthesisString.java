// 678. Valid Parenthesis String

public class ValidParenthesisString{

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString(")("));
    }

    // Greedy
    public static boolean checkValidString(String s) {
        int high = 0, low = 0;
        for(char ch : s.toCharArray()) {
            switch(ch) {
                case '(':
                    high++;
                    low++;
                    break;
                case ')':
                    high--;
                    if(low>0)low--;
                    break;
                case '*':
                    high++;
                    if(low>0)low--;
                    break;
            }

            if(high<0) return false;
        }

        return low==0;
    }


    /* recursion with memorization
    public static boolean checkValidString(String s) {
        int[][] memory = new int[s.length()][s.length()];

        return recursion(s, 0, 0, memory);
    }

    private static boolean recursion(String s, int idx, int diff, int[][] memory) {
        if(idx == s.length()) return diff == 0;
        if(diff < 0) return false;
        if(memory[idx][diff] != 0) return memory[idx][diff] == 1;

        char ch = s.charAt(idx);
        if(ch == '(') memory[idx][diff] = recursion(s, idx+1, diff+1, memory) ? 1 : -1;
        else if(ch == ')') memory[idx][diff] =  recursion(s, idx+1, diff-1, memory) ? 1 : -1;
        else memory[idx][diff] =  (recursion(s, idx+1, diff, memory) || recursion(s, idx+1, diff+1, memory) || recursion(s, idx+1, diff-1, memory)) ? 1 : -1;

        return memory[idx][diff] == 1;
    }
    */

}
