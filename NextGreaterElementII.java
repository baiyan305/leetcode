// 503. Next Greater Element II

import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] ret1 = nextGreaterElements(new int[]{1,2,1});
        for(int i : ret1) System.out.print(i + ", ");
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[nums.length];
        for(int i=nums.length * 2 -1; i>=0; i--) {
            while(!stack.isEmpty() && nums[i%nums.length] >= nums[stack.peek()]) stack.pop();
            if(i<nums.length) ret[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i%nums.length);
        }

        return ret;
    }

}