// 42. Trapping Rain Water

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {2,0,2,1,1};
        System.out.println(trap(height));
    }

    // Stack方法
    public static int trap(int[] height) {
        if(height == null || height.length < 3) return 0;

        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; i++) {
            if(!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                while(!stack.isEmpty() && height[i]>=height[stack.peek()]) {
                    int low = height[stack.pop()];
                    if(!stack.isEmpty()) {
                        water += (Math.min(height[i], height[stack.peek()]) - low) * (i-stack.peek()-1);
                    }
                }
            }
            stack.push(i);
        }

        return water;
    }

    // https://www.youtube.com/watch?v=8BHqSdwyODs
    // 双指针，遍历一次即可。
    /*
    public static int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int leftPeak = height[0], rightPeak = height[height.length-1], left = 1, right = height.length-2, water = 0;

        while(left <= right) {
            if(leftPeak <= rightPeak) {
                if(height[left] < leftPeak) water += leftPeak - height[left];
                else leftPeak = height[left];
                left++;
            } else {
                if(height[right] < rightPeak) water += rightPeak - height[right];
                else rightPeak = height[right];
                right--;
            }
        }

        return water;
    }
    */

    // 对于一个bar，如何找到它能存多少水呢？
    // 找到bar左边最大的元素，右边最大的元素，bar能存多少水取决于两者中更小的那个。
    // 这种方法需要从左到右扫描一遍，之后从右到左扫描一遍。
    /*
    public static int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int[] leftPeak = new int[height.length];

        int leftMax = height[0];
        for(int i=1; i<height.length-1; i++) {
            leftPeak[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int waterTrapped = 0, rightMax = height[height.length-1];
        for(int i=height.length-2; i>0; i--) {
            int ceiling = Math.min(rightMax, leftPeak[i]);
            rightMax = Math.max(rightMax, height[i]);

            if(ceiling > height[i]) waterTrapped += ceiling - height[i];
        }

        return waterTrapped;
    }
    */

}