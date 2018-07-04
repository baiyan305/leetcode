// 496. Next Greater Element I

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] arrs = nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for(int num : arrs) System.out.print(num+", ");
        System.out.println();
        int[] arrs1 = nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        for(int num : arrs1) System.out.print(num+", ");
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //key is value and value is position
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++) map.put(nums1[i], i);

        int[] arr = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            int value = nums2[i];
            while(!stack.isEmpty() && value >= stack.peek()) stack.pop();
            if(map.containsKey(value)){
                arr[map.get(value)] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(value);
        }

        return arr;
    }

}