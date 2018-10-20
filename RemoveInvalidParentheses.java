// 301. Remove Invalid Parentheses

import java.util.*;

public class RemoveInvalidParentheses {

    public void run() {
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses(")("));
        System.out.println(removeInvalidParentheses("(()(()"));
        System.out.println("123");
    }

    /* BFS
       利用 Level Order Traverse的思路
       第一层相当于删除一个字符后的所有字符串
       第二层相当于删除两个字符后的所有字符串
       ...

       如果在第一层发现了Valid的字符串，那么就可以停止循环了，因为题目是找最小删除次数的字符串
    */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String str = queue.poll();
                if(isValid(str)) {
                    res.add(str);
                } else {
                    char[] arr = str.toCharArray();
                    for(int j=0; j<arr.length; j++) {
                        if( (arr[j] != '(' && arr[j] != ')') || (j != 0 && arr[j] == arr[j-1]) ) continue;
                        String sub = str.substring(0,j)+str.substring(j+1);
                        if(!visited.contains(sub)) {
                            queue.add(sub);
                            visited.add(sub);
                        }
                    }
                }
            }
            if(!res.isEmpty()) {
                break;
            }
        }

        return res;
    }

    private boolean isValid(String str) {
        int left = 0, right = 0;

        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++) {
            char ch = arr[i];
            if(ch == '(') left++;
            else if(ch == ')') {
                right++;
                if(right>left) return false;
            }
        }

        return left == right;
    }


}