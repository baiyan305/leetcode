// 42. Trapping Rain Water

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {2,0,2,1,1};
        System.out.println(trap(height));
    }

	// 双指针解法
	// 双指针解法
    // 举例
    // 8,           4,   X,     20,       X,      4,       10
    // leftMax      left                          right    rightMax
    //
    // 这个例子中，left指向的4, 能够储存的水量已经定了。左边的最大值是8, 右边的最大值至少是10，其实是20。
    // 但是能储存的水量，是由较低的板子决定的，所以能储存的水量是由左边的8决定的。
    // 这是就可以计算left指向的4可以储存的水量了。之后left++，继续计算下一个。
    //
    // 注意，right指向的4能储存的水量，还不确定，我们不知道短板到底是8还是10。如果left, right之间有一个比较大的值，那么10就是短板，如果没有大的值，那么8就是短板。
    public int trap(int[] height) {
        int water = 0, left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;

        while(left < right) {
            if(height[left] > leftMax)
                leftMax = height[left];
            if(height[right] > rightMax)
                rightMax = height[right];

            if(leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }

    // Stack做法, 不是特别好解释，用一个比较简单的例子解释比较好。
    // 比如[3,2,1,3]
    // 2那个柱子，可以trap1个水，1那个位置，可以trap2个水。
    // Stack中维护递减的序列。 那个前3个数字都存入栈中，3，2，1
    // 最后一个3来了
    // 先看2,1,3这3个柱子能trap的水，先不要管最前面那个3
    // 取2，3中比较小的那个，减去1，乘以2,3的距离，结果是1，就是2，1，3这3个柱子，能储存的水
    // 1那个柱子其实是可以trap2个水，但是目前我们只算出来1个，另外那个后面会得到
    //
    // 下面一步，栈中剩下3，2，当前柱子为最后一个3
    // 重复之前的套路，取3，3中比较小的那个，减去2，乘以3，3的距离，得出2
    /*
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lowIdx = stack.pop();
                if(!stack.isEmpty())
                    water += (Math.min(height[i], height[stack.peek()]) - height[lowIdx]) * (i-stack.peek()-1);
            }

            stack.push(i);
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